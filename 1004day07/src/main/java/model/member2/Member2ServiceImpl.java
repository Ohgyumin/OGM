package model.member2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class Member2ServiceImpl implements Member2Service{

	@Autowired
	private Member2DAO member2dao;
	
	@Override
	public void insertMember(Member2VO vo) {
		member2dao.insertMember2(vo);	
	}

	@Override
	public void updateMember(Member2VO vo) {
		member2dao.updateMember2(vo);
	}

	@Override
	public void deleteMember(Member2VO vo) {
		member2dao.deleteMember2(vo);
	}

	@Override
	public ArrayList<Member2VO> getMember(Member2VO vo) {
		return member2dao.getMember2(vo);
	}

	@Override
	public Member2VO selectMember(Member2VO vo) {
		return member2dao.selectMember2(vo);
	}

}
