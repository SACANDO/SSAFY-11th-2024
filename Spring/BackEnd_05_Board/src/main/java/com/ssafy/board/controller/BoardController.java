package com.ssafy.board.controller;

import java.io.IOException;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.repository.BoardRepository;
import com.ssafy.board.repository.BoardRepositoryImpl;
import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BoardService service = BoardServiceImpl.getInstance();
	private BoardRepository repository = BoardRepositoryImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 모든 board요청은 해당 서블릿으로 오게 되어있음
		String action = request.getParameter("action");

		switch (action) {
		case "writeform": {
			doWriteForm(request, response);
			break;
		}
		case "write":
			doWrite(request, response);

		case "doList":
			doList(request, response);
		}

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 객체에 담아서 서비스를 호출하겠다.
		Board board = new Board(title, writer, content);
		service.writeBoard(board);
		response.sendRedirect("board?action=list");
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/writeform.jsp").forward(request, response);

	}

}
