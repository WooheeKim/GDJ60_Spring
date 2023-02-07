package com.woo.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woo.s1.member.MemberDAO.";
	
	
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE+"getMemberDetail", memberDTO);
		
	}
	
	public List<MemberDTO> getMemberList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}

	// setMemberAdd
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	
}
