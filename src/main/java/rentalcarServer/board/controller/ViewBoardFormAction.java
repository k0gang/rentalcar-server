package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class ViewBoardFormAction
 */
public class ViewBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBoardFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boardCode = request.getParameter("boardCode");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
	
        if (boardCode != null) {
            BoardDao boardDao = BoardDao.getInstance();
            int boardId = Integer.parseInt(boardCode);
            
            BoardResponseDto board = boardDao.findBoard(boardId);
            
            request.setAttribute("userId", id);
            request.setAttribute("board", board);
            request.setAttribute("boardCode", board.getBoardCode());
            
            System.out.println(id);
            System.out.println(board);
            System.out.println(board.getBoardCode());
            
            request.getRequestDispatcher("/view").forward(request, response);
		} else {
			response.sendRedirect("/board");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
