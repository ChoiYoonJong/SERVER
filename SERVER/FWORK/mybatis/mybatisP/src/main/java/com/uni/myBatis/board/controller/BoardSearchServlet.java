package com.uni.myBatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.myBatis.board.model.dto.Board;
import com.uni.myBatis.board.model.dto.PageInfo;
import com.uni.myBatis.board.model.dto.SearchCondition;
import com.uni.myBatis.board.model.service.BoardService;
import com.uni.myBatis.board.model.service.BoardServiceImpl;
import com.uni.myBatis.common.Pagination;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/searchBoard.do")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService bs = new BoardServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String search = request.getParameter("search");
		
		SearchCondition sc = new SearchCondition();
		
		switch(condition) {
		case "writer" :
			sc.setWriter(search);
			break;
		case "title" :
			sc.setTitle(search);
			break;
		case "content" :
			sc.setContent(search);
			break;
		
		}
		
		int listCount;
		
		try {
			listCount = bs.getSearchListCount(sc);
			System.out.println(listCount);
			
			int currentPage = 1;
			if(request.getParameter("currentPage")!=null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int pageLimit = 10;
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
			
			ArrayList<Board> list;
			
			list = bs.selectSearchList(sc,pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("search", search);
			request.setAttribute("condition", condition);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
