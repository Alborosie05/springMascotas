package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.service.ListService;
import es.salesianos.service.OwnerService;

@Controller
public class controlador {
	
	@Autowired
	OwnerService serviceOwner;

	@GetMapping(path="addOwner")
	public ModelAndView getAddOwnerPage() {
		ModelAndView model = new ModelAndView("addOwner");
		model.addObject("owner",new Owner());
		return model;
	}
	
	@PostMapping(path="/addOwner")
	public String saveOwner(Owner owner)  {
		serviceOwner.addOwner(owner);
		return "ownerSaved";
	}
	
	
	//Accedemos aqui cuando le damos al enlace para listar los propietarios
	@GetMapping(path="listOwner")
	public String getListOwnerPage() {
		
		return "listOwner";
	}
	
	@Autowired
	ListService serviceList;
	
	//Accedemos aqui cuando le damos al submit para listar a los propietarios
	@PostMapping(path = "/listAllOwners")
	public ModelAndView addOwner() {
		List<Owner> owners = serviceList.listAllOwners();
		System.out.println(owners);
		ModelAndView model = new ModelAndView("listOwner");
		model.addObject("listAllOwners", owners);
		return model;
	}
	
	//accedemos aqui al clicar en el enlace de EDIT
	
	@GetMapping(path="/editOwner")
	public ModelAndView getEditOwnerPage(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("ownerEdited");
		Owner owner = serviceOwner.search(codOwner);
		model.addObject("owner",owner);
		
		
		return model;
	}
	
	//accedemos aqui cuando le damos a actualizar el propietario
	
	@PostMapping(path = "/updateOwner")
	public String updateOwner(@ModelAttribute Owner owner) {
		serviceOwner.insertOrUpdate(owner);
		
		return "listOwner";
	}
	
	
	
	@GetMapping(path="/confirmarEliminadoOwner")
	public ModelAndView getDeleteOwnerPage(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("confirmDelete");
		model.addObject("codOwner",codOwner);
		
		return model;
	}
	
	@PostMapping(path = "/deleteOwner")
	public String deleteOwner(@RequestParam Integer codOwner, @RequestParam String answer) {
		
		if(answer.equals("SI")) {
			serviceOwner.deleteOwner(codOwner);
		}
		return "listOwner";
	}
}
