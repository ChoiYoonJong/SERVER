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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/updateMember.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로.
		
		//request.setCharacterEncoding("UTF-8"); // 설정을 했기때문에 주석 처리 혹은 작성하지 않아도 된다.
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] interests = request.getParameterValues("interest");
		String interest="";
		if(interest !=null) {
			interest = String.join(",", interests);
		}
		
		Member updateMem = new MemberService().updateMember(new Member(userId, userName, phone, email, address, interest));
		//update 하고 수정이 되면 바로 객체를 담아온다.  update 도 하고 select 도 하면 두가지를 하게된다.
		
		if(updateMem !=null) {
			request.getSession().setAttribute("msg", "성공적으로 회원정보를 수정하였습니다."); 
			request.getSession().setAttribute("loginUser", updateMem); //수정된 내용을 loginUser객체에 넘겨준다.
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원수정에 실패하였습니다.");
			
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
