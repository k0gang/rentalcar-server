package rentalcarServer.reservations.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.reservations.model.ReservationsDao;

import java.util.List;

public class CheckReservation extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String startDateTime = request.getParameter("startDateTime");
        String endDateTime = request.getParameter("endDateTime");
        String carCode = request.getParameter("carCode");
        
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        System.out.println(carCode);

        ReservationsDao reservationsDao = ReservationsDao.getInstance();
        boolean isAvailable = reservationsDao.checkAvailability(startDateTime, endDateTime, carCode);

        if (isAvailable) {
            response.getWriter().write("available");
        } else {
            response.getWriter().write("not available");
        }
    }
    
    
}