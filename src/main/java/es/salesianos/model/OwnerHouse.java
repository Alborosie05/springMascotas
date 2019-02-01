package es.salesianos.model;

public class OwnerHouse {
	private int codOwner;
	private int codHouse;
	private String typeHouse;
	private Owner owner;
	private House house;
	
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getCodOwner() {
		return codOwner;
	}
	public void setCodOwner(int codOwner) {
		this.codOwner = codOwner;
	}
	public int getCodHouse() {
		return codHouse;
	}
	public void setCodHouse(int codHouse) {
		this.codHouse = codHouse;
	}
	public String getTypeHouse() {
		return typeHouse;
	}
	public void setTypeHouse(String typeHouse) {
		this.typeHouse = typeHouse;
	}
}
