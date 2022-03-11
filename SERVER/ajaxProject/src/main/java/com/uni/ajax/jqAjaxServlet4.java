package com.uni.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.uni.model.vo.User;

/**
 * Servlet implementation class jqAjaxServlet4
 */
@WebServlet("/jqTest4.do")
public class jqAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqAjaxServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<User> list = new ArrayList<>();
		
		list.add(new User(1,"유재석",30, '남'));
		list.add(new User(2,"한지민",32, '여'));
		list.add(new User(3,"배수지",31, '여'));
		list.add(new User(4,"송지효",32, '여'));
		list.add(new User(5,"김종국",33, '남'));
		
		int input = Integer.parseInt(request.getParameter("input"));
		
		User findUser = null;
		JSONObject jsonUser = null;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNo() == input) {
				findUser = list.get(i);
				
				jsonUser = new JSONObject();
				jsonUser.put("no", findUser.getNo());
				jsonUser.put("name", findUser.getName());
				jsonUser.put("age", findUser.getAge());
				jsonUser.put("gender", findUser.getGender() + "");
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//System.out.println(jsonUser.toJSONString());//String 방식으로..  // Null 값일때는 에러가 나온다.
		//System.out.println(jsonUser.toString());// Null 값일때는 에러가 나온다.
		System.out.println(jsonUser);
		
		
		
		out.print(jsonUser);
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
