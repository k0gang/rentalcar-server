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
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class WriteBoardFormAction
 */
@WebServlet("/WriteBoardFormAction")
public class WriteBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteBoardFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId"); // 세션에서 현재 로그인한 사용자의 아이디 가져오기
		System.out.println(userId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();

		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		String userId = user.getUserId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("userId : " + userId);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		boolean isValid = true;

		if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;

		if (isValid) {
BoardRequestDto boardDto = new BoardRequestDto();
			
			boardDto.setUserId(userId);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			
			BoardResponseDto board = boardDao.createBoard(boardDto);
			session.setAttribute("board", board);
			
			if (board == null) {
				System.out.println("문의등록 실패");
				//저장 실패
				response.sendRedirect("/board");
			} else {
				//저장 성공
				System.out.println("board : " + board);
				response.sendRedirect("/board/view?boardCode=" + board.getBoardCode());
			}
		} else {
			System.out.println("글이 없거나 제목이 없거나 ");
			response.sendRedirect("/boardAction");
		}
	}
}