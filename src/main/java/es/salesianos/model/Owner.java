package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner {
	private Integer codOwner;
	private String name;
	private String surname;
	private List<Pet> pets = new ArrayList<Pet>();
	private List<OwnerHouse> ownerhouses = new ArrayList<OwnerHouse>();
	
	public void setMascotas(List<Pet> mascotas) {
		this.pets=mascotas;
	}
	
	public List<Pet> getMascotas() {
		return pets;
	}
	
	public void addToListPet(Pet pet) {
		pets.add(pet);
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public void setCodOwner(Integer codOwner) {
		this.codOwner=codOwner;
	}
	
	public Integer getCodOwner() {
		return codOwner;
	}

	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "User [codOwner="+codOwner+ "name=" + name + ", surname=" + surname + "]";
	}
	

}
