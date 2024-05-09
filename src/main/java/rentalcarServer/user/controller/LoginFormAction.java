package rentalcarServer.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.user.model.User;
import rentalcarServer.user.model.UserDao;
import rentalcarServer.user.model.UserRequestDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class LoginFormAction
 */
@WebServlet("/LoginFormAction")
public class LoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginFormAction() {
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
		System.out.println("dㅇㅇ?");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		System.out.println("userId : " + id);
		String password = request.getParameter("password");
		System.out.println("password : " + password);
		
		boolean isValid = true;

		if (id == null || id.equals(""))
			isValid = false;
		else if (password == null || password.equals(""))
			isValid = false;

		if (isValid) {
			// 연동된 데이터 베이스로부터
			// 유저의 정보를 조회 하고,
			UserDao userDao = UserDao.getInstance();
			UserResponseDto user = userDao.findUserByIdAndPassword(id, password);
			HttpSession session = request.getSession();
			
			System.out.println("user : " + user);
			
			if (user != null) {
				session.setAttribute("user", user);
				String test = (String) session.getAttribute("userId");
				System.out.println("loginForm 에서의 userId : " + user.getUserId());
				 request.getRequestDispatcher("/mypage").forward(request, response);
			} else {
				System.out.println("로그인ㄴㄴ");
				response.sendRedirect("/login");
			}
			// 정보가 일치하면
			// 로그인 처리 후, 페이지 이동

		} else {
			response.sendRedirect("/login");
		}
	}

}