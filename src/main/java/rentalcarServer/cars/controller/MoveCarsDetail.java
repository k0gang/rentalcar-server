package rentalcarServer.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;

/**
 * Servlet implementation class MoveCarsDetail
 */
@WebServlet("/MoveCarsDetail")
public class MoveCarsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveCarsDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarsDao carsDao = CarsDao.getInstance();
		String carCode = request.getParameter("car_code");
		int carId = Integer.parseInt(carCode);
		
		CarsResponseDto car = carsDao.findCarsByCarCode(carId);
		
		String startDatetime = request.getParameter("startDate");
        String endDatetime = request.getParameter("endDate");
        
        System.out.println("startDate : " + startDatetime);
        System.out.println("endDate : " + endDatetime);

		request.setAttribute("car", car);
		
		request.getRequestDispatcher("/carsDetailForm?car_code="+carCode).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
