package com.multicampus.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

@Controller
public class InsertBoardController {

	@RequestMapping("/insertBoard.do")
	public void insertBoard(BoardDAO boardDAO, BoardVO vo, HttpServletRequest request) {
		boardDAO.insertBoard(vo);
	}
}