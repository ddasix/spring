package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �׽�Ʈ ��ü�� Lookup�Ѵ�.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. �˻��� ��ü �׽�Ʈ
		BoardVO vo = new BoardVO();
		
		vo.setTitle("JDBC ����");
		vo.setWriter("������");
		vo.setContent("JDBC ����.....................");
		boardService.insertBoard(vo);
		
//		vo.setTitle("���� ����");
//		vo.setContent("���� ����...............");
//		vo.setSeq(1);
//		boardService.updateBoard(vo);
		
//		boardService.deleteBoard(vo);
		
//		vo.setSeq(1);		
//		boardService.getBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}		
	}
}
