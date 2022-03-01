package com.uni.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uni.member.model.dto.Member;

public class MemberDao {

	public Member login(Connection conn, String userId, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		 Member m  = null;
		String sql = "SELECT * FROM MEMBER WHERE USERID = ? AND PASSWORD = ?";

		try {
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new Member();
				m.setMemberId(rs.getString("USERID"));
				m.setMemberPwd(rs.getString("PASSWORD"));
				m.setMemberName(rs.getString("USERNAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;

	}

}
