package com.uni.controller.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSessionServlet
 */
@WebServlet("/deleteSession.do")
public class DeleteSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8;");
		request.getSession().invalidate();//		// session에 저장된 값들을 지움(무효화) -> 로그인 되어있던 회원의 정보를 없애 로그아웃시킴
		String html="<html>";
		html+="<body>";
		html+="<h1>"+"로그아웃되었습니다</h1>";
		html+="<button onclick='location.replace(\""+request.getContextPath()+"/\");'>메인으로</button>";
		html+="</body>";
		html+="</html>";
		
		PrintWriter out=response.getWriter();
		out.print(html);
		if (request.isRequestedSessionIdValid() == true) {
		       
	        out.print("세션 아이디가 유효합니다.<hr/>");
	    }
	   
	    else {
	       
	        out.print("세션 아이디가 유효하지 않습니다.<hr/>");
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
