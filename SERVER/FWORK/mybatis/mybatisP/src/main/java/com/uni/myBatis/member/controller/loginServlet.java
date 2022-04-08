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
 * Servlet implementation class loginServlet
 */
@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService ms = new MemberServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		Member loginUser;
		try {
			loginUser = ms.loginMember(m);
			
			
			if(loginUser != null) {
				request.getSession().setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath());
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			request.setAttribute("msg", "로그인실패");
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
