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
		
		String boardCode = (String) session.getAttribute("boardCode");
		String userId = (String) session.getAttribute("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// Backend 에서 전달받은 데이터에 대한 유효성 검증 
		boolean isValid = true;

		if (boardCode == null || boardCode.equals(""))
			isValid = false;
		else if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;
		
		System.out.println("boardCode : " + boardCode);
		System.out.println("userId : " + userId);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		if (isValid) {			
			BoardRequestDto boardDto = new BoardRequestDto(Integer.parseInt(boardCode), userId, title, content);
			BoardDao boardDao = BoardDao.getInstance();
			BoardResponseDto board = boardDao.createBoard(boardDto);
			
			if (board == null) {
				System.out.println("문의등록 실패");
				//저장 실패
				response.sendRedirect("/main");
			} else {
				//저장 성공
				System.out.println("board : " + board);
				response.sendRedirect("/mypage");
			}
		} else
			System.out.println("실패다");
			response.sendRedirect("/board");
	}

}