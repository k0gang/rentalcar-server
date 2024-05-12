package rentalcarServer.cars.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;
import rentalcarServer.user.model.UserDao;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class SearchCarsAction
 */
@WebServlet("/SearchCarsAction")
public class SearchCarsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDatetime = request.getParameter("start-datetime");
        String endDatetime = request.getParameter("end-datetime");
        
        System.out.println("(a)startDate : " + startDatetime);
        System.out.println("(a)endDate : " + endDatetime);
        
        // 여기서부터는 대여일시와 반납일시를 활용하여 데이터베이스에서 예약 가능한 차량을 검색하고,
        // 해당 정보를 다시 클라이언트에게 전송하거나, 웹 페이지를 생성하는 등의 작업을 수행할 수 있습니다.
        
        // 예를 들어, 예약 가능한 차량 목록을 데이터베이스로부터 가져오고 해당 결과를 다음 페이지로 전달할 수 있습니다.
        // request.setAttribute("cars", availableCars); // "availableCars"는 예약 가능한 차량 목록을 담고 있는 객체
        
        // 다음 페이지로 포워딩합니다.
        // request.getRequestDispatcher("/result.jsp").forward(request, response);  
        
        boolean isValid = true;

		if (startDatetime == null || startDatetime.equals(""))
			isValid = false;
		else if (endDatetime == null || endDatetime.equals(""))
			isValid = false;

		if (isValid) {
			CarsDao carsDao = CarsDao.getInstance();
			List<CarsResponseDto> carList = carsDao.findValidCars(startDatetime, endDatetime);
			HttpSession session = request.getSession();
			
			session.setAttribute("startDatetime", startDatetime);
			session.setAttribute("endDatetime", endDatetime);
			
			session.setAttribute("carList", carList);
			System.out.println("carList 저장 완료");
			
			request.getRequestDispatcher("/searchResultCars").forward(request, response);

		} else {
			response.sendRedirect("/mypage");
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
