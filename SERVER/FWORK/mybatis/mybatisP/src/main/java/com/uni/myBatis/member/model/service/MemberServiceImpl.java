package com.uni.myBatis.member.model.service;

import static com.uni.myBatis.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.uni.myBatis.member.model.dao.MemberDao;
import com.uni.myBatis.member.model.dto.Member;

public class MemberServiceImpl implements MemberService {
	
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int insertMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();
		
		int result = mDao.insertMember(sqlSession, m );
		
		if(result >0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		return result;
		
	}
	
	

}
