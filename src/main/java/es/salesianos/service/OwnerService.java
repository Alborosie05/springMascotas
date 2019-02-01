package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.repository.Repository;

@Service

public class OwnerService {
	
	@Autowired
	private Repository repository;
	
	
	public Owner assembleOwnerFromRequest(HttpServletRequest req) {
		return OwnerAssembler.assembleOwnerFrom(req);
	}
	
	public void addOwner(Owner owner) {
		repository.insert(owner);
	}

	public void insertOrUpdate(Owner ownerFormulario) {
		Owner userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public void deletePets(Integer codOwner) {
		repository.deletePetsByOwner(codOwner);
	}
	
	public Owner search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	
	
	
	

}
