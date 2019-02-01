package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.service.OwnerService;
import es.salesianos.service.PetService;

public class updatePetServlet extends HttpServlet{
OwnerService service = new OwnerService();
PetService petservice = new PetService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pet pet = PetAssembler.assemblePetFrom(req);
		String nomAeditar = req.getParameter("nameAeditar");
		petservice.updatePet(pet, nomAeditar);
		Owner owner = service.search(Integer.parseInt(req.getParameter("codOwner")));
		req.setAttribute("owner", owner);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
