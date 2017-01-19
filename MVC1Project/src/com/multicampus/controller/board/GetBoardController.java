package com.multicampus.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �� ��ȸ ��� ó��");
		
		// 1. ����� �Է����� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. �˻� ����� JSP ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
		// ModelAndView�� ����� �����ʹ� �ڵ����� request�� ��ϵȴ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); // Model ���� ����
		mav.setViewName("getBoard");   // View  ���� ����
		return mav;
	}

}
