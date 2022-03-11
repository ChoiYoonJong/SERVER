package com.uni.board.controller;

import java.io.File;
import java.io.IOException;

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

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/updateBoard.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
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
			
			int bno = Integer.parseInt(multiRequest.getParameter("bno"));
			
			Board b = new Board();
			b.setBoardTitle(multiRequest.getParameter("title"));
			b.setBoardContent(multiRequest.getParameter("content"));
			b.setCategory(multiRequest.getParameter("category"));
			b.setBoardNo(bno);
			
			Attachment at = null; //일단 파일이 없을 수 있기때문에 null로 설정
			
			if(multiRequest.getOriginalFileName("upFile") != null) {
				
				String originName = multiRequest.getOriginalFileName("upFile");
				String changeName = multiRequest.getFilesystemName("upFile");
				
				//확인
				System.out.println(originName);
				System.out.println(changeName);
				
				
				at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
				
				
				if(multiRequest.getParameter("originFile") != null) {
					File deleteFile = new File(savePath + multiRequest.getParameter("originFile"));
					
					//확인
					System.out.println("deleteFile" + deleteFile);
					System.out.println("deleteFile savePath" + savePath + multiRequest.getParameter("originFile"));
					
					deleteFile.delete();
					
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFile")));
				}else {// 파일이 없을때 
					at.setRefBoardNo(bno); //bno 삽입
				}
			}
			
			
			
			int result = new BoardService().updateBoard(b,at);
			if(result > 0) {
				response.sendRedirect("detailBoard.do?bno="+ bno);
			}else {
				request.setAttribute("msg", "게시글 수정실패");
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
