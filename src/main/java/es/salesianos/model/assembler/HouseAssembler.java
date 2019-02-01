package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.House;
import es.salesianos.model.Owner;

public class HouseAssembler {
	public static House assembleHouseFrom(HttpServletRequest req) {
		House house = new House();
		String codHouse=req.getParameter("codHouse");
		if(null != codHouse) {
			house.setCodHouse(Integer.parseInt(codHouse));
		}
		String direction = req.getParameter("direction");
		house.setDirection(direction);
		return house;
	}
}
