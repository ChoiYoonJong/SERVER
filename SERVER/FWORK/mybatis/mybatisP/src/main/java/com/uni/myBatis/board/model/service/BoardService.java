package com.uni.myBatis.board.model.service;

import java.util.ArrayList;

import com.uni.myBatis.board.model.dto.Board;
import com.uni.myBatis.board.model.dto.PageInfo;
import com.uni.myBatis.board.model.dto.SearchCondition;

public interface BoardService {

	int getListCount() throws Exception;

	ArrayList<Board> selectList(PageInfo pi) throws Exception;

	Board selectBoard(int bno) throws Exception;

	int getSearchListCount(SearchCondition sc) throws Exception;

	ArrayList<Board> selectSearchList(SearchCondition sc, PageInfo pi);

}
