package es.salesianos.model;

import java.util.List;
import java.util.ArrayList;

public class House {
	private int codHouse;
	private String direction;
	private List<OwnerHouse> ownerHouses = new ArrayList<OwnerHouse>();
	
	public int getCodHouse() {
		return codHouse;
	}
	public void setCodHouse(int codHouse) {
		this.codHouse = codHouse;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
