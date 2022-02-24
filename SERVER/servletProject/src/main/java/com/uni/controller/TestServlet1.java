package com.uni.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/test1.do")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foodArr = request.getParameterValues("food");
		
		if(foodArr != null) {
			for(int i = 0; i < foodArr.length; i++) {
				System.out.println("foodArr["+i +"]"+foodArr[i]);
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보출력화면</title>");
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("span.name{color:orange; font-weight:bold;}");
		out.println("span.gender{color:yellow; font-weight:bold; background-color:black;}");
		out.println("span.age{color:green; font-weight:bold;}");
		out.println("span.city{color:blue; font-weight:bold;}");
		out.println("span.height{color:navy; font-weight:bold;}");
		out.println("span.food{color:purple; font-weight:bold;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인정보 결과(GET)화면</h2>");
		out.printf("<span class='name'>%s</span>님은 ", name);// 포맷지정하는 메소드 printf(자바코드를 이용해서 편하게 작업 가능)
		out.printf("<span class='age'>%s</span>살이시며 ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
		out.printf("키 <span class='height'>%s</span>", height);
		out.printf("<span class='gender'>%s</span>입니다.", gender);
		out.print("좋아하는 음식은 <span class='food'>");
		// 자바코드 내이기 때문에 반복문, 조건문도 사용 가능
		if(foodArr != null) {
			for(int i = 0; i < foodArr.length; i++) {
				
				out.printf("%s", foodArr[i]);

			}
		}
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
