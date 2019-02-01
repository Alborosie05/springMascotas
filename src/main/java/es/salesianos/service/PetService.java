package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.repository.Repository;


public class PetService {

	private Repository repository = new Repository();

	
	
	public Pet assemblePetFromRequest(HttpServletRequest req) {
		return PetAssembler.assemblePetFrom(req);
	}
	
	public void addPet(Pet pet) {
		repository.insertPet(pet);
		
	}
	
	public void deletePet(Integer codOwner, String nombre) {
		repository.deletePet(codOwner, nombre);
	}
	
	public void updatePet(Pet pet, String nomAeditar) {
		repository.updatePet(pet, nomAeditar);
	}
}
