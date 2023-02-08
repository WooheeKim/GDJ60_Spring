package com.woo.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	public MemberDAO memberDAO;
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberAdd(memberDTO);
	}
	
	
	public List<MemberDTO> getMemberList() throws Exception {
		
		return memberDAO.getMemberList();
		
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception {
		return memberDAO.getMemberDetail(memberDTO);
	}
	
}
