package model.board;

import java.util.ArrayList;

public interface BoardService {
	void insertBoard(BoardVO vo); // �޼��� �ñ״�ó
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	ArrayList<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
}
