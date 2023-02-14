package com.woo.s1.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woo.s1.member.MemberDAO.";
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd", memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	
	public int setMemberPage(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberPage", memberDTO);
	}
	
	public MemberDTO setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return (MemberDTO) sqlSession.selectList(NAMESPACE+"setMemberUpdate", memberDTO);
	}
}
