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
 * Servlet implementation class UpdateBoardFormAction
 */
@WebServlet("/UpdateBoardFormAction")
public class UpdateBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBoardFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		
//		String boardCode = request.getParameter("boardCode");
//		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
//		String admin = request.getParameter("admin");
		
		
		
		int boardCode = (int) session.getAttribute("boardCode");
		String userId = (String) session.getAttribute("userId");
//		String title = (String) session.getAttribute("title");
//		String content = (String) session.getAttribute("content");
		boolean admin = (boolean) session.getAttribute("admin");
		
		System.out.println("boardCode : " + boardCode);
		System.out.println("userId : " + userId);
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("admin : " + admin);

		boolean isValid = true;

		if (boardCode == 0)
			isValid = false;
		else if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;
//		else if (admin == null)
//			isValid = false;

		if (isValid) {
			BoardDao boardDao = BoardDao.getInstance();

			BoardRequestDto boardDto = new BoardRequestDto(boardCode, userId, title, content, admin);
			BoardResponseDto board = boardDao.updateBoard(boardDto);

			if (board == null) {
				System.out.println("되는건지 안되는건지");
				response.sendRedirect("/board");
			} else {
				System.out.println("게시물 수정 완료.");

				response.sendRedirect("/board");
			}
		} else {
			System.out.println("그냥 보드로 가는중");
			response.sendRedirect("/board");
		}
	}
}
