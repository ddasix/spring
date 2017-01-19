package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 테스트 객체를 Lookup한다.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. 검색된 객체 테스트
		BoardVO vo = new BoardVO();
		
		vo.setTitle("JDBC 제목");
		vo.setWriter("관리자");
		vo.setContent("JDBC 내용.....................");
		boardService.insertBoard(vo);
		
//		vo.setTitle("수정 제목");
//		vo.setContent("수정 내용...............");
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
