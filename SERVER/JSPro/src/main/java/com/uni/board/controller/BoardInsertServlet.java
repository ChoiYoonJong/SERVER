package com.uni.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.uni.board.model.service.BoardService;
import com.uni.board.model.vo.Attachment;
import com.uni.board.model.vo.Board;
import com.uni.common.MyFileRenamePolicy;
import com.uni.member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/insertBoard.do")//url 맵핑
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 업로드를 위한 라이브러리 : cos.jar (http://www.servlets.com)
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1_1. 전송파일 용량 제한 (int maxSize)
			//		: 10Mbyte로 제한  ([참고] cos.jar로 파일 업로드 시 최대 2기가(1.6)까지만 가능)
			//      1Kbyte = 1024byte (킬로바이트)
			//		1Mbyte = 1024Kbyte = 1024 * 1024 byte (메가바이트)
			//		1Gbyte = 1024Mbyte = 1024 * 1024 * 1024 Byte (기가바이트)
			//		10mbyte = 10 * 1024 * 1024 byte
			
			int maxSize = 10*1024*1024; //10mb
			
			//경로 설정
			String resources = request.getSession().getServletContext().getRealPath("/resources"); //절대경로를 사용해서 경로를 추출해서 담아준다.
			
			//폴더 설정
			String savePath = resources + "\\board_upfiles\\"; //실제 저장되는 폴더
			
			//경로 잘되었는지 확인
			System.out.println("savePath" + savePath);
			
			//MultipartRequest객체 생성
			//시스템 파일 명 저장 // 시스템파일 명으로 조회하게 해준다. 
			// 시스템파일명저장 DefaultFileRenamePolicy() = 호수 jar에서 제공해는 같은 파일 명이 있으면 뒤에1 카운트숫자를 추가해서 저장해주는 방식
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new MyFileRenamePolicy());
			
			String category = multiRequest.getParameter("category");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			//회원 유저 번호
			//session 에서 가져온다. 없으므로
			int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			
			//보드 객체 생성
			Board b = new Board();
			b.setCategory(category);
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(String.valueOf(userNo));
			
			//파일첨부
			Attachment at = null;
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				String originName = multiRequest.getOriginalFileName("upfile");//원본파일 명
				
				String changeName = multiRequest.getFilesystemName("upfile");//시스템파일 명
				
				//에러확인
				System.out.println("originName : " + originName);
				System.out.println("changeName : " + changeName);
				
				at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
				
			}
			
			int result = new BoardService().insertBoard(b,at);
			
			if(result >0) {
				request.getSession().setAttribute("msg", "게시물 등록 성공");
				response.sendRedirect("listBoard.do");
			}else {
				//실패했을때 삭제
				if(at != null) {
					File failedFile = new File(savePath+at.getChangeName()); //업로드 한 파일 제목 시스템파일명
					failedFile.delete();//파일삭제
				}
				
				request.setAttribute("msg", "게시글등록실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			

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
