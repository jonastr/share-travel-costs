package com.sharetravelcosts.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sharetravelcosts.entities.Travel;
import com.sharetravelcosts.storage.TravelRepository;
 
@Controller
public class IndexController {
	@Autowired
	private TravelRepository repository;
	
	@GetMapping(path="/")
	String listTravels() {
		return "redirect:/travels";
	}
	
    @GetMapping(path="/travels")
    String listTravels(Map<String, Object> model) {
    		List<Travel> travels = repository.findAll();
    		model.put("travels", travels);
        return "index";
    }
}