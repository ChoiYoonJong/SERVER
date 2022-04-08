package com.uni.myBatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.uni.myBatis.board.model.dto.Board;
import com.uni.myBatis.board.model.dto.PageInfo;
import com.uni.myBatis.board.model.dto.SearchCondition;

public class BoardDao {

	public int getListCount(SqlSession sqlSession) throws Exception {
		
		return sqlSession.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// * offset : 몇개의 게시글을 건너 뛰고 조회할 지에 대해 계산
				// ex) boardLimit : 5
				// currentPage = 1		1~5		0개의 게시글 건너 뛰고 1부터 5개 조회
				// currentPage = 2		6~10	5개의 게시글 건너 뛰고 6부터 5개 조회
				// currentPage = 3		11~15	10개의 게시글 건너 뛰고 11부터 5개 조회
				// currentPage = 4		16~20	15개의 게시글 건너 뛰고 16부터 5개 조회
				
				int offset = (pi.getCurrentPage() - 1)* pi.getBoardLimit();
				
				RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
				/* 1 페이지 ( 1 ~ 10 )
				 10건 조회
				 10건 조회
				 
				 2 페이지 ( 11 ~ 20 )
				 10건 조회
				 20개 조회 후 10번째 부터 10건
				 
				 3 페이지 ( 21 ~ 30 )
				 10건 조회
				 30개 조회 후 20번째 부터 10건
				.
				.
				.
				 10 페이지 ( 91 ~ 100 )
				 10건 조회
				 100개 조회 후 90번째 부터 10건*/

				return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
			}

	public int updateCount(SqlSession sqlSession, int bno) throws Exception {
		
		return sqlSession.update("boardMapper.updateCount", bno);
	}

	public Board selectBoard(SqlSession sqlSession, int bno) throws Exception {
		
		return sqlSession.selectOne("boardMapper.selectBoard", bno);
	}

	public int getSearchListcount(SqlSession sqlSession, SearchCondition sc) throws Exception {
		
		return sqlSession.selectOne("boardMapper.getSearchListCount", sc);
	}

	public ArrayList<Board> selectSearchList(SqlSession sqlSession, SearchCondition sc, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1)* pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", sc, rowBounds);
	}

}
