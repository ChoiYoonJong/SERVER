package com.uni.board.model.service;

import static com.uni.common.JDBCTemplate.close;
import static com.uni.common.JDBCTemplate.commit;
import static com.uni.common.JDBCTemplate.getConnection;
import static com.uni.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.board.model.dao.BoardDao;
import com.uni.board.model.vo.Attachment;
import com.uni.board.model.vo.Board;
import com.uni.board.model.vo.PageInfo;
import com.uni.board.model.vo.Reply;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();//connection 연결
		
		int listCount = new BoardDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();//connection 연결
		
		ArrayList<Board> list = new BoardDao().selectList(conn,pi);
		
		close(conn);
		return list;//받아주고 list return해준다.
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();//connection 연결
		
		int result1 = new BoardDao().insertBoard(conn, b);//conn정보와 b 넘겨준다.
		
		int result2 = 1; //result2 초기값을 1
		if(at != null) {
			result2 = new BoardDao().insertAttachement(conn, at);
		}
		
		if(result1 * result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result1 * result2;
	}

	public Board selectBoard(int bno) {
		Connection conn = getConnection();//connection 연결
		
		int result = new BoardDao().increaseCount(conn, bno);
		Board b = null;
		if(result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, bno);
		}else {
			rollback(conn);
		}
		close(conn);
		return b;
	}

	public Attachment seleceAttachment(int bno) {
		Connection conn = getConnection();//connection 연결
		
		Attachment at = new BoardDao().selectAttachment(conn, bno);
		close(conn);
		return at;
	}

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();//connection 연결
		
		int result1 = new BoardDao().updateBoard(conn, b);
		
		int result2 = 1;
		if(at !=null) {
			if(at.getFileNo() != 0) {
				result2 = new BoardDao().updateAttachment(conn, at);
			}else {
				result2 = new BoardDao().insertNewAttachement(conn, at);
			}
		}
		if(result1 * result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();//connection 연결
		ArrayList<Board> list = new BoardDao().selectThList(conn);
		
		close(conn);
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();//connection 연결
		
		int result1 = new BoardDao().insertThBoard(conn, b);
		int result2 = new BoardDao().insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}

	public ArrayList<Attachment> selectThumbnail(int bid) {
		Connection conn = getConnection();//connection 연결
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn, bid);
		
		close(conn);
		return list;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();//connection 연결
		
		int result = new BoardDao().insertReply(conn, r);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Reply> selectRlist(int bid) {
		Connection conn = getConnection();//connection 연결
		ArrayList<Reply> list = new BoardDao().selectRlist(conn, bid);
		
		close(conn);
		return list;
	}

	public ArrayList<Board> selectTopList() {
		Connection conn = getConnection();

		ArrayList<Board> list= new BoardDao().selectTopList(conn);

		close(conn);
		return list;
	}

}
