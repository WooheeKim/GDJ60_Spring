package com.woo.s1.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo.s1.board.BbsDAO;
import com.woo.s1.board.BbsDTO;
import com.woo.s1.util.Pager;

@Repository
public class BankBookCommentDAO implements BbsDAO {
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.woo.s1.bankBook.BankBookCommentDAO.";
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		return 0;
	}
	
	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		return 0;
	}
}