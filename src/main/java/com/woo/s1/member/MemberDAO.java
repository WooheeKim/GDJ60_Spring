package com.woo.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woo.s1.member.MemberDAO";
	
	// setMemberAdd
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE+"getMemberDetail", memberDTO);
		
	}
	
	

	
	
}
