package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.House;
import es.salesianos.model.Owner;
import es.salesianos.model.OwnerHouse;
import es.salesianos.model.assembler.HouseAssembler;
import es.salesianos.model.assembler.OwnerHouseAssembler;
import es.salesianos.service.HouseService;
import es.salesianos.service.OwnerService;

public class viewHousesServlet extends HttpServlet{
	private HouseService service = new HouseService();
	private OwnerService serviceOwner = new OwnerService();
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Owner owner = serviceOwner.assembleOwnerFromRequest(req);
			req.setAttribute("owner", owner);
			redirect(req, resp);
		}
		protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwnerHouse.jsp");
			dispatcher.forward(req,resp);
		}
}
