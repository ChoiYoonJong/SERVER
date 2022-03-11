package com.uni.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.uni.model.vo.User;

/**
 * Servlet implementation class jqAjaxServlet5
 */
@WebServlet("/jqTest5.do")
public class jqAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqAjaxServlet5() {
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
		
		char gender = request.getParameter("gender").charAt(0);
		
		// JSONArray : JSONObject를 배열 형태로 나타내어 인덱스별로 나누어 저장할 수 있는 객체
		//	[{"k":v, "k":v ..},{"k":v, "k":v ..},{"k":v, "k":v ..}]
		JSONArray jArr = new JSONArray();
		JSONObject jsonUser = null;
		
		for(User user:list) {
			if(user.getGender()==gender) {
				jsonUser = new JSONObject();//객체 생성
				
				jsonUser.put("no", user.getNo());
				jsonUser.put("name", user.getName());
				jsonUser.put("age", user.getAge());
				jsonUser.put("gender", user.getGender() + "");
				
				jArr.add(jsonUser);
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jArr);//jArr를 return 해준다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
