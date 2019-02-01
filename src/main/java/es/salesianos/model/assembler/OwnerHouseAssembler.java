package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.House;
import es.salesianos.model.Owner;
import es.salesianos.model.OwnerHouse;

public class OwnerHouseAssembler {
	public static OwnerHouse assembleOwnerHouseFrom(House house, Owner owner, String typeHouse) {
		OwnerHouse ownerHouse = new OwnerHouse();
		if(null != owner.getCodOwner()) {
		ownerHouse.setCodOwner(owner.getCodOwner()); 
		}
		ownerHouse.setCodHouse(house.getCodHouse());
		ownerHouse.setHouse(house);
		ownerHouse.setOwner(owner);
		ownerHouse.setTypeHouse(typeHouse);

		return ownerHouse;
	}
}
