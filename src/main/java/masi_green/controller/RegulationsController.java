package masi_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import masi_green.manager.RegulationsManager;

@RestController
public class RegulationsController {

	@Autowired
	RegulationsManager regulationsManager; 
	
	@GetMapping(value = "/regulations")
	public String regulations() {
		final String regulations = regulationsManager.getRegulations();
		if(regulations != null) {
			return regulations;
		} else {
			return "";
		}
	}
}
