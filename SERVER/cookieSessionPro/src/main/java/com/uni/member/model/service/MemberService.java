package com.uni.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.uni.member.common.JDBCTemplate;
import com.uni.member.model.dao.MemberDao;
import com.uni.member.model.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	public Member login(String userId, String password) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = dao.login(conn, userId, password);
		
		try {
			if(conn !=null) conn.close();
		
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}
