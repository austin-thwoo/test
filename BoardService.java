package com.icia.TravelMaker.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.TravelMaker.dao.BoardDAO;
import com.icia.TravelMaker.dto.BoardCategoryDTO;
import com.icia.TravelMaker.dto.BoardDTO;
import com.icia.TravelMaker.dto.BoardListDTO;
import com.icia.TravelMaker.dto.BoardViewDTO;
import com.icia.TravelMaker.dto.CommentsListDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public int boardInsert(BoardDTO dto) throws IllegalStateException, IOException {
		if(!dto.getBIMGFILE().isEmpty()) {
			dto.setBIMG(System.currentTimeMillis()+"_"+dto.getBIMGFILE().getOriginalFilename());
			dto.getBIMGFILE().transferTo(new File("D:\\ICIA\\Jong Won\\Team_404\\TravelMaker_Proj\\TravelMaker\\src\\main\\webapp\\resources\\boardFile\\"+dto.getBIMG()));
		}else {
			dto.setBIMG("test");
		}
		return dao.boardInsert(dto);
	}

	public List<BoardListDTO> boardList(BoardCategoryDTO dto) {
		return dao.boardList(dto);
	}

	public BoardCategoryDTO boardCategory(BoardCategoryDTO dto) {
		return dao.boardCategory(dto);
	}

	public BoardViewDTO boardDetail(BoardViewDTO viewdto) {
	 
		
		return dao.boardDetail(viewdto);
		
		
	}

	public List<CommentsListDTO> boardDetailComments(BoardViewDTO viewdto) {
		
		return dao.boardDetailComments(viewdto);
	}

}
