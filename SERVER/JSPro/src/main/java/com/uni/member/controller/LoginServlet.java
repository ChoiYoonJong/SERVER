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
import com.uni.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginMember.do")//url mapping 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식에서 받아주려면 먼저 encoding 해줘야한다. ID,PWD 에 한글이 없긴하지만 psot 방식에서는 encoding 해줘야한다.
		//request.setCharacterEncoding("UTF-8"); // 설정을 했기때문에 주석 처리 혹은 작성하지 않아도 된다.
		
		//전달된 값을 꺼내서 객체에 기록해준다.
		String userId = request.getParameter("userId"); //request.getParameter("name값") 으로 값을 가져올 수 있다.
		System.out.println(userId);
		
		String userPwd = request.getParameter("userPwd"); // request.getParameter("name값") 으로 값을 가져올 수 있다.
		//String originPwd = request.getParameter("userPwd"); // 나중에 비밀번호 변경시 변수에 비밀번호를 담아놓았다.
		String originPwd = (String)request.getAttribute("originPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
	// Member 객체에 담아 준다. MemberService 를 호출해서 login 한다음  로그인 정보.. Member 객체를 다 받아와서 담아준다.
		System.out.println("loginUser"+ loginUser);//연동이 됬는지 확인 값이 받아 왔는지 체크확인..
		
		
		if(loginUser != null) {//null 이 아닌경우 로그인 성공한경우
					
					HttpSession session = request.getSession();//session이 있으면 있는거 가져오고 없으면 생성을 해서 
					                                           //session객체에다가 login 객체 정보를 담는다. 그래야 session  유지될때 객체안에 값이 유지가 될 수 있다.
					session.setAttribute("loginUser", loginUser); // setAttribute 해서 loginUser 객체를 session 에 담는다.
					session.setAttribute("originPwd", originPwd);
					
					response.sendRedirect(request.getContextPath()); // 화면 전환을 단순하게 원래 있는 화면으로 하면 되기때문에 sendRedirect로 작성한다.
				
				}else {//로그인 실패시 나오는 
					request.setAttribute("msg", "로그인에 실패했습니다.");
					//에러가 난 내용을 session 에 유지 될 필요가 없다. 그래서 requset.setAttribute 메세지만 보여주고 끝내준다.
					
					RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
					//request 담아기때문에 RequestDispatcher로... 
					view.forward(request, response);//view.forawad 해서 request,response을 가지고 화면을 호출
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
