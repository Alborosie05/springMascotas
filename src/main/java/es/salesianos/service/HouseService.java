package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.House;
import es.salesianos.model.Owner;
import es.salesianos.model.OwnerHouse;
import es.salesianos.model.assembler.HouseAssembler;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.repository.Repository;

public class HouseService {
	private Repository repository = new Repository();
	
	
	
	public House assembleHouseFromRequest(HttpServletRequest req) {
		return HouseAssembler.assembleHouseFrom(req);
	}
	
	public void addHouse(House house) {
		repository.insertHouse(house);
	}

	public void addOwnerHouse(OwnerHouse ownerHouse) {
		repository.insertOwnerHouse(ownerHouse);
		
	}

	public House searchHouse(House house) {
		return repository.searchHouse(house);
		
	}
}
