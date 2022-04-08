package com.uni.myBatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.myBatis.member.model.dto.Member;
import com.uni.myBatis.member.model.service.MemberService;
import com.uni.myBatis.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberinsertServlet
 */
@WebServlet("/insertMember.do")
public class MemberinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService ms = new MemberServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberinsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, userPwd, userName, email, birthday, gender, phone, address);
		try {
			ms.insertMember(m);
			response.sendRedirect(request.getContextPath());
			
		} catch (Exception e) {
			request.setAttribute("msg", "회원가입실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
