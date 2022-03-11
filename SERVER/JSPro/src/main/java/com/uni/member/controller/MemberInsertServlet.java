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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insertMember.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로.
		
		//request.setCharacterEncoding("UTF-8"); // 설정을 했기때문에 주석 처리 혹은 작성하지 않아도 된다.
		
		String userId =request.getParameter("userId");
		String userPwd =request.getParameter("userPwd");
		String userName =request.getParameter("userName");
		String phone =request.getParameter("phone");
		String email =request.getParameter("email");
		String address =request.getParameter("address");
		
		//관심분야는 배열로 넘어 온다.
		String[] interests = request.getParameterValues("interest");
		
		String interest ="";//배열을 풀어서 String 형으로..
		if(interests !=null) {
			interest = String.join(",", interests);// , 로 구분해서 
		}
		
		Member mem = new Member(userId, userPwd, userName, phone, email,  address, interest ); 
		
		int result = new MemberService().insertMember(mem); //insert 로 하면 result 값을 int 로 받아준다. 
		
		if(result > 0) {// 결과 값이 0 보다 크면 회원 가입이 성공이 된거다.
			request.getSession().setAttribute("msg", "회원가입성공");
			response.sendRedirect(request.getContextPath()); // 회원 가입 성공후 메인 호출.. 바뀐게 남아있지 않아야하고 메인으로 이동해야함 
		}else { // 에러 페이지 , 가입실해 했을때 
			
			request.setAttribute("msg", "회원가입실패.");
			
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
