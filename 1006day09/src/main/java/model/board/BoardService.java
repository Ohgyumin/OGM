package model.board;

import java.util.ArrayList;

public interface BoardService {
	void insertBoard(BoardVO vo); // 메서드 시그니처
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	ArrayList<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
}
