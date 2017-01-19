package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 기능 처리");
		
		// 1. 사용자 입력정보 추출(검색 기능은 나중에...)
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 검색 결과와 JSP 화면 정보를 ModelAndView에 저장하여 리턴한다.
		// ModelAndView에 저장된 데이터는 자동으로 request에 등록된다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model 정보 저장
		mav.setViewName("getBoardList.jsp");   // View  정보 저장
		return mav;
	}

}





