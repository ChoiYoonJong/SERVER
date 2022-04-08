package com.uni.myBatis.board.model.service;

import static com.uni.myBatis.common.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.uni.myBatis.board.model.dao.BoardDao;
import com.uni.myBatis.board.model.dto.Board;
import com.uni.myBatis.board.model.dto.PageInfo;
import com.uni.myBatis.board.model.dto.SearchCondition;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao = new BoardDao(); 
	
	@Override
	public int getListCount() throws Exception{
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.getListCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public Board selectBoard(int bno) throws Exception {
		SqlSession sqlSession = getSqlSession();
		int result = boardDao.updateCount(sqlSession, bno);
		
		Board b = null;
		if(result > 0) {
			sqlSession.commit();
			b = boardDao.selectBoard(sqlSession,bno);
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		return b;
	}

	@Override
	public int getSearchListCount(SearchCondition sc) throws Exception  {
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.getSearchListcount(sqlSession,sc);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(SearchCondition sc, PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession,sc,pi);
		
		sqlSession.close();
		return list;
	}

}
