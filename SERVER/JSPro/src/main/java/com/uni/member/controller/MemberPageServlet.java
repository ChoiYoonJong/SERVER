package com.uni.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.member.model.service.MemberService;
import com.uni.member.model.vo.Member;

/**
 * Servlet implementation class MemberPageServlet
 */
@WebServlet("/mypageMember.do")//url 연결
public class MemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session 에서 loginUser 정보를 가져올 수 있다. 현재 session 에 있는 Member loginUser 정보 가져오기
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		String userId = loginUser.getUserId();//loginUser 안에 있는 String userId 가져오기
		
		//userId 를 가지고 Member 정보를 조회
		Member member = new MemberService().selectMember(userId);// 정보를 다시 조회 db에서 정보를 가져오기.
		
		System.out.println(member);// 제대로 들고왔는지 확인
		
		RequestDispatcher view = null;//화면 전환
		
		if(member != null) {//만약에 member 가 null 이 아니면
			request.setAttribute("loginUser", member);//loginUser 에 member 를 담아준다.
			view = request.getRequestDispatcher("views/member/myPage.jsp");
			
		}else {
			request.setAttribute("msg", "조회에실패했습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");//화면 전환
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
