package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerService;

public class editPetServlet extends HttpServlet{
OwnerService service = new OwnerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		String nombre = req.getParameter("nombre");
		req.setAttribute("codOwner", codOwner);
		req.setAttribute("nombre", nombre);
		req.setAttribute("nombreAeditar", nombre);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/petEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
