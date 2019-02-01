package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.service.ListService;
import es.salesianos.service.OwnerService;

public class verificationDeleteOwnerServlet extends HttpServlet{
	private ListService servicio = new  ListService();
	OwnerService service = new OwnerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		req.setAttribute("codOwner", codOwner);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmDelete.jsp");
		dispatcher.forward(req,resp);
	}
}
