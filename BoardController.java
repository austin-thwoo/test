package com.icia.TravelMaker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.TravelMaker.dto.BoardCategoryDTO;
import com.icia.TravelMaker.dto.BoardDTO;
import com.icia.TravelMaker.dto.BoardViewDTO;
import com.icia.TravelMaker.dto.CommentsListDTO;
import com.icia.TravelMaker.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	private ModelAndView mav;
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/boardList")
	private ModelAndView boardList(@ModelAttribute BoardCategoryDTO dto) {
		mav();
		mav.addObject("boardList", service.boardList(dto));
		mav.addObject("boardCategory", service.boardCategory(dto));
		mav.setViewName("board/BoardList");
		return mav;
	}
	
	@RequestMapping(value = "/goBoardInsertForm")
	private ModelAndView goBoardInsertForm() {
		mav();
		mav.setViewName("board/BoardInsertForm");
		return mav;
	}
	
	@RequestMapping(value = "/boardInsert")
	private ModelAndView boardInsert(@ModelAttribute BoardDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.boardInsert(dto) == 1) {
			mav.setViewName("redirect:/boardList");
		}else{
			mav.setViewName("redirect:/goBoardInsertForm");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardDetail")
	private ModelAndView boardDetail(@ModelAttribute BoardViewDTO viewdto ) {
		
		mav.addObject("boardDetail", service.boardDetail(viewdto));
		mav.addObject("commentslist", service.boardDetailComments(viewdto));		
		mav.setViewName("board/BoardDetail");
		
		return mav;
	}

}
