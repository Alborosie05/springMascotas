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
import es.salesianos.repository.Repository;
import es.salesianos.service.ListService;
import es.salesianos.service.OwnerService;

public class ListadoMascotasServlet extends HttpServlet {
	private ListService servicio = new  ListService();
	OwnerService service = new OwnerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		Owner ownerFromDataBase = new Owner();
		ownerFromDataBase.setCodOwner(Integer.parseInt(codOwner));
		Owner owner1 = service.search(ownerFromDataBase.getCodOwner());
		req.setAttribute("owner", owner1);
		List<Pet> listAllPets = servicio.listAllPets(owner1.getCodOwner());
		/*List<Pet> listAllPets = servicio.listAllPets(Integer.parseInt(codOwner)); */
		req.setAttribute("listAllPets", listAllPets);
		
		
		
		/*Owner ownerFormulario= new Owner();
		ownerFormulario.setCodOwner(Integer.parseInt(codOwner));
		Owner ownerFromDatabase = service.search(ownerFormulario.getCodOwner());
		req.setAttribute("owner", ownerFromDatabase);*/
		
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
