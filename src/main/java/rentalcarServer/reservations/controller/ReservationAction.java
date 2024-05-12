package rentalcarServer.reservations.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;
import rentalcarServer.reservations.model.ReservationsDao;
import rentalcarServer.reservations.model.ReservationsRequestDto;
import rentalcarServer.reservations.model.ReservationsResponseDto;

/**
 * Servlet implementation class ReservationAction
 */
@WebServlet("/ReservationAction")
public class ReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationAction() {
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
		CarsDao carDao = CarsDao.getInstance();
		ReservationsDao reservationsDao = ReservationsDao.getInstance();

		String carCode = request.getParameter("car_code");
		int carId = Integer.parseInt(carCode);

		String userId = (String) session.getAttribute("userId");
		
		String status = request.getParameter("status");
		System.out.println("status : " + status);
		

		String startDatestr = (String) session.getAttribute("startDatetime");
		String endDatestr = (String) session.getAttribute("endDatetime");
		System.out.println("(r)startDate : " + startDatestr);
		System.out.println("(r)endDate : " + endDatestr);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        java.util.Date startDate = null;
        java.util.Date endDate = null;
        try {
            startDate = dateFormat.parse(startDatestr);
            endDate =  dateFormat.parse(endDatestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Date 객체를 Timestamp으로 변환
        Timestamp startTimestamp = new Timestamp(startDate.getTime());
        Timestamp endTimestamp = new Timestamp(endDate.getTime());
        

		String carPrice = request.getParameter("carPrice");
		System.out.println("carPrice : " + carPrice);
		int price = Integer.parseInt(carPrice);

		String carName = request.getParameter("carName");

		ReservationsRequestDto responseDto = new ReservationsRequestDto();
		responseDto.setUserId(userId);
		responseDto.setCarCode(carId);
		responseDto.setCarPrice(price);
		responseDto.setBorrowDate(startTimestamp);
		responseDto.setReturnDate(endTimestamp);
		responseDto.setStatus(status);
		responseDto.setCarName(carName);
		
		ReservationsResponseDto reservation = reservationsDao.createReservation(responseDto);

		request.setAttribute("reservation", reservation);

		CarsResponseDto car = carDao.findCarsByCarCode(carId);

		request.setAttribute("car", car);

		request.getRequestDispatcher("/reservationResult").forward(request, response);
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
