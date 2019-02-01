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
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.HouseAssembler;
import es.salesianos.model.assembler.OwnerHouseAssembler;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.service.HouseService;
import es.salesianos.service.OwnerService;
import es.salesianos.service.PetService;

public class addHouseServlet extends HttpServlet{
private HouseService service = new HouseService();
private OwnerService serviceOwner = new OwnerService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		House house = HouseAssembler.assembleHouseFrom(req);
		House houseInDataBase = null;
		Owner ownerInDataBase = null;
		String codOwner = req.getParameter("codOwner");
		String typeHouse = req.getParameter("typeHouse");
		service.addHouse(house);
		houseInDataBase = service.searchHouse(house);
		ownerInDataBase = serviceOwner.search(Integer.parseInt(codOwner));
		OwnerHouse ownerHouse = OwnerHouseAssembler.assembleOwnerHouseFrom(houseInDataBase, ownerInDataBase, typeHouse);
		service.addOwnerHouse(ownerHouse);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwner.jsp");
		dispatcher.forward(req,resp);
	}
}
