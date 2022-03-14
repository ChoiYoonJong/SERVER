package com.uni.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uni.el.model.vo.Member;

/**
 * Servlet implementation class TestFourServlet
 */
@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestFourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member requestMember = new Member("유재석",20,"010-1234-5678","yu@naver.com"); // 객체 생성
		Member sessionMember = new Member("남주혁",30,"010-1234-1111","na@naver.com"); // 객체 생성
		
		HttpSession session = request.getSession();
		request.setAttribute("member", requestMember); 
		session.setAttribute("member", sessionMember);
		RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl4.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
