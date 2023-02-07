package com.woo.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woo.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberAddTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("shoemarker");
		memberDTO.setPw("123123");
		memberDTO.setName("shoe");
		memberDTO.setAddress("gaebong");
		memberDTO.setPhone("010-1234-5678");
		memberDTO.setEmail("shoe@gmail.com");
		int result = memberDAO.setMemberAdd(memberDTO);
		assertEquals(1, result);
		
	}

}
