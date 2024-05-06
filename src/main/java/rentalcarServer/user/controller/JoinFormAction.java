package rentalcarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.user.model.UserDao;
import rentalcarServer.user.model.UserRequestDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class JoinFormAction
 */
@WebServlet("/JoinFormAction")
public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinFormAction() {
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

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String telecom = request.getParameter("telecom");
		String phone = request.getParameter("phone");

		// Backend 에서 전달받은 데이터에 대한 유효성 검증 
		boolean isValid = true;

		if (id == null || id.equals(""))
			isValid = false;
		else if (password == null || password.equals(""))
			isValid = false;
		else if (name == null || name.equals(""))
			isValid = false;
		else if (birth == null || birth.equals(""))
			isValid = false;
		else if (telecom == null || telecom.equals(""))
			isValid = false;
		else if (phone == null || phone.equals(""))
			isValid = false;

		// Processing Page 에서는 사용자에게 보여주는 화면을 작성하지 않음 
		// 요청에 대한 응답 처리를 작성 
		// 1) 페이지 이동 처리 (흐름을 제어)
		if (isValid) {
			// 연동된 데이터 베이스로부터 
			// 유저의 정보를 조회 하고,
			// 중복에 대한 검증을 한 후에
			// 가입 처리 후, 페이지 이동

			UserRequestDto userDto = new UserRequestDto(id, password, name, birth, telecom, phone);
			UserDao userDao = UserDao.getInstance();
			UserResponseDto user = userDao.createUser(userDto);
			if (user == null) {
				
				System.out.println("가입 실패");
				//저장 실패
				response.sendRedirect("/join");
			} else {
				//저장 성공
				
				System.out.println("user : " + user);
				response.sendRedirect("/login");
			}

		} else
			response.sendRedirect("/join");
	}

}