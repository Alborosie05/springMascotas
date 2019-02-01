package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.OwnerHouse;
import es.salesianos.repository.Repository;
import es.salesianos.service.ListService;

public class listHouseServlet extends HttpServlet{
	private ListService servicio = new  ListService();
	private Repository repository = new  Repository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		List<OwnerHouse> listAllOwnerHouses = servicio.listAllOwnerHouses(Integer.parseInt(codOwner));
		req.setAttribute("listAllOwnerHouses", listAllOwnerHouses);
		
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwnerHouse.jsp");
		dispatcher.forward(req,resp);
	}
}
