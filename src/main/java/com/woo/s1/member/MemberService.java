package com.woo.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberUpdate(memberDTO);
	}
}
