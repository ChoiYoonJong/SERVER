package com.uni.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCookieServlet
 */
@WebServlet("/cookieTest.do")
public class CheckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키생성
		Cookie cookie = new Cookie("Id","user11");
		
		//유효기간설정
		cookie.setMaxAge(24*60*60);//1일
		//쿠키전송
		response.addCookie(cookie);
		
		//쿠키생성
		Cookie cookie2 = new Cookie("email","green@uni.com");
		//쿠키전송
		response.addCookie(cookie2);
		
		//응답페이지
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String html="<html>";
		html+="<body>";
		html+="<p>쿠키가전송되었습니다</p>";
		html+="<button onclick='location.assign(\"checkCookie.do\");'>쿠키값 확인 </button>";//assign : 히스토리를 가지고 있어 이전페이지로 이동이가능
		html+="</body>";
		html+="</html>";
				
		out.print(html);

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
