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
 * Servlet implementation class MemberUpdatePwdServlet
 */
@WebServlet("/updatePwdMember.do")
public class MemberUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId(); //오브젝트 타입이기때문에 형변환 //아이디 값을 가져온다.
		
		//나머지
		String userPwd = request.getParameter("userPwd"); 
		String newPwd = request.getParameter("newPwd"); //변경할 비밀번호 가져온다.
		String originPwd = (String)request.getAttribute("originPwd");
		
		//userId 같이 넘겨서 비밀번호 변경
		Member updateMem = new MemberService().updatePwd(userId, userPwd, newPwd);
		
		//변경된 객체의 정보를 다시 가지고 와서 session에 다시 담는다.
		RequestDispatcher view = request.getRequestDispatcher("views/member/pwdUpdateForm.jsp"); //어떤 테그값이 넘어오면 그 팝업창을 닫는다.
		if(updateMem != null) {
			request.setAttribute("sTag", "Y"); //Y로 넘겨준다.
			request.setAttribute("msg", "성공적으로 비밀번호를 변경하였습니다."); //msg 넘겨준다.
			request.getSession().setAttribute("loginUser", updateMem);//다시 loginUser 에 담아준다.
			request.getSession().setAttribute("originPwd",originPwd);// session 에 originPwd를 담아준다.
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패하였습니다.");
		}
		
		view.forward(request, response); // requset, response 를 넘겨준다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
