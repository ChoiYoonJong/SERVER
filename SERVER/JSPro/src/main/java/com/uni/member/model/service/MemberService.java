package com.uni.member.model.service;

import static com.uni.common.JDBCTemplate.close;
import static com.uni.common.JDBCTemplate.commit;
import static com.uni.common.JDBCTemplate.getConnection;
import static com.uni.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.uni.member.model.dao.MemberDao;
import com.uni.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {//Service 에 와서 Connection 해준다...
		Connection conn = getConnection();
		
		//Dao 에서 Member 객체를  받아와서 Member 에 담아준다.
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);//메소드를 호출하고 이때 넘겨져야하는 값은 conn정보 , 위에서 매개변수로 받아온 userId, userPwd 
		close(conn);//conn 을 닫아준다.
		
		return loginUser;// 받아온 loginUser를 login 객체에 담아서 return 해준다. 
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();//connection 연결
		int result = new MemberDao().insertMember(conn,m);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;//return result 값으로 
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();//connection 연결
		Member mem = new MemberDao().selectMember(conn, userId); //MemberDao 에서 조회 conn,userId 값으로 조회
		close(conn);//닫아준다.
		return mem;//Member 객체인 mem 을 return 해준다.
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();//connection 연결
		int result = new MemberDao().deleteMember(conn, userId);//int result 결과 값을 받아온다.
		if(result >0) {
			commit(conn);
		}else {//잘되지 않았을때 rollback 시켜준다.
			rollback(conn);
		}
		close(conn);
		return result;//result 값으로 리턴해준다.
	}

	public Member updateMember(Member m) {//Dao에 updateMember 의 객체 m 을 호출
		Connection conn = getConnection();//connection 연결
		Member updateMem = null;
		int result = new MemberDao().updateMember(conn, m);
		if(result>0) { // 잘 되었으면 updateMem을 return 해준다.
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
		}else {//잘 안됬으면 rollback 해준다.
			rollback(conn);
		}
		close(conn);
		
		return updateMem;//
	}

	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MemberDao().updatePwd(conn, userId, userPwd, newPwd);
		System.out.println(result + " Service======= " );
		if(result > 0) { //만약에 결과 값이 0 보다 크면 제대로 작동 된다.
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId); //updateMem 에 다시 조회해서 담아준다.
		}else{
			rollback(conn);
		}
		close(conn);
		return updateMem;//Member 객체를 return 해준다.
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();//connection 연결
		int result = new MemberDao().idCheck(conn, userId); 
		
		close(conn);
		return result;
	}

}
