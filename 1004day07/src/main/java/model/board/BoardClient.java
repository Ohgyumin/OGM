package model.board;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		vo.setContent("臂 累己");
		vo.setTitle("力格");
		vo.setWriter("包府磊");
		bs.insertBoard(vo);
		
		ArrayList<BoardVO> datas=bs.getBoardList(vo);
		for(BoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}

