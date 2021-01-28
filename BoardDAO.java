package com.icia.TravelMaker.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.icia.TravelMaker.dto.BoardCategoryDTO;
import com.icia.TravelMaker.dto.BoardDTO;
import com.icia.TravelMaker.dto.BoardListDTO;
import com.icia.TravelMaker.dto.BoardViewDTO;
import com.icia.TravelMaker.dto.CommentsListDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int boardInsert(BoardDTO dto) {
		return sql.insert("Board.boardInsert", dto);
	}

	public List<BoardListDTO> boardList(BoardCategoryDTO dto) {
		return sql.selectList("Board.boardList", dto);
	}

	public BoardCategoryDTO boardCategory(BoardCategoryDTO dto) {
		return sql.selectOne("Board.boardCategory", dto);
	}

	public BoardViewDTO boardDetail(BoardViewDTO viewdto) {
		//sql.insert(statement)
		System.out.println("여기는 DAO입니다."+viewdto.toString() );
		return sql.selectOne("Board.boardDetail", viewdto);


	}

	public List<CommentsListDTO> boardDetailComments(BoardViewDTO viewdto) {
		
		return sql.selectList("Board.boardDetailComments", viewdto);
	}

}
