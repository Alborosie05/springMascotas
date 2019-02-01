package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.service.OwnerService;
import es.salesianos.service.PetService;

public class deletePetServlet extends HttpServlet{
private PetService service = new PetService();
private OwnerService serviceOwner = new OwnerService();
private OwnerAssembler ownerAssembler = new OwnerAssembler();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		String nombre = req.getParameter("nombre");
		service.deletePet(Integer.parseInt(codOwner), nombre);
		Owner owner = serviceOwner.search(Integer.parseInt(codOwner));
		req.setAttribute("owner", owner);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerEdited.jsp");
		dispatcher.forward(req,resp);
	}

}
