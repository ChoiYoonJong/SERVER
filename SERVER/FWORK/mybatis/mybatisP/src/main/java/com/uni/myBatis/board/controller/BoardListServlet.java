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
import com.uni.myBatis.board.model.service.BoardService;
import com.uni.myBatis.board.model.service.BoardServiceImpl;
import com.uni.myBatis.common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/listBoard.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService bs = new BoardServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		try {
			listCount = bs.getListCount();
			
			int currentPage = 1;
			
			if(request.getParameter("currentPage")!=null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int pageLimit = 10;
			
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
			
			ArrayList<Board> list = bs.selectList(pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);			
			
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
