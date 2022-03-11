package com.uni.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uni.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/deleteMember.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId"); //userId 값을 가져온다. 
		
		int result = new MemberService().deleteMember(userId);// 실행을 시키면 result 값이 넘어온다. 
		
		if(result > 0) { // 0보다 크면 제대로 작동 된거이다.
			HttpSession session = request.getSession();//현재 연결되어있는 session 정보를 가지고 와서
			session.removeAttribute("loginUser");// removeAttribute를 사용해서 session 안에 loginUser 값이 들어간 객체를 삭제 해준다.
			session.setAttribute("msg", "회원탈퇴가 완료되었습니다. 복구관련사항은 관리자에게 문의하세요");//session 메세지 처리 해준다.
			response.sendRedirect(request.getContextPath());//메인으로 가게한다.
		}else {//제대로 되지 않은 경우이기 때문에 에러페이지로 이동하게한다.
			request.setAttribute("msg", "회원탈퇴에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
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
