package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardRequestDto;
import rentalcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class DeleteBoardFormAction
 */
@WebServlet("/DeleteBoardFormAction")
public class DeleteBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		BoardDao boardDao = BoardDao.getInstance();
		
		BoardResponseDto board = (BoardResponseDto) session.getAttribute("board");
		
		Integer boardCode = board.getBoardCode();
		String userId = board.getUserId();
		
		BoardRequestDto boardDto = new BoardRequestDto();
		
		boardDto.setBoardCode(boardCode);
		boardDto.setUserId(userId);
		
		boolean result = boardDao.deleteBoard(boardDto);
		
		if(result) {
			session.removeAttribute("board");
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/deleteBoard");
		}
	}

}
