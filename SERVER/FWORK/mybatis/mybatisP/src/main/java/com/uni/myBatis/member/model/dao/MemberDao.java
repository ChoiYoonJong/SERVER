package com.uni.myBatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.uni.myBatis.member.model.dto.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		Member loginUser = null;
		
		loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		
		System.out.println("loginUser : " + loginUser);
		return loginUser;
	}

	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*int result = sqlSession.insert("memberMapper.insertMember", m);
		return result;*/
		
		return sqlSession.insert("memberMapper.insertMember",m);
	}

}
