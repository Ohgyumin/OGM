package model.member2;

import java.util.ArrayList;

public interface Member2Service {
	void insertMember(Member2VO vo);
	void updateMember(Member2VO vo);
	void deleteMember(Member2VO vo);
	ArrayList<Member2VO> getMember(Member2VO vo);
	Member2VO selectMember(Member2VO vo);
}
