package com.sharetravelcosts.manage;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sharetravelcosts.travels.Travel;
import com.sharetravelcosts.travels.TravelRepository;
 
@Controller
public class ManageController {
	@Autowired
	private TravelRepository repository;
	
    @GetMapping(path="/travels")
    String listTravels(Map<String, Object> model) {
    		List<Travel> travels = repository.findAll();
    		model.put("travels", travels);
        return "manage";
    }
    
    @GetMapping(path="/travels/create")
    String createTravel(Map<String, Object> mode) {
    		return "create_travel";
    }
    
    @PostMapping(path="/travels/create")
    String createTravel(
    		Map<String, Object> mode,
    		@RequestParam String destination,
    		@RequestParam String start,
    		@RequestParam String end) 
    {
    		SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
    		try {
	    		Date startDate = df.parse(start);
	    		Date endDate = df.parse(end);
	    		Travel travel = new Travel(destination, startDate, endDate);
	    		repository.insert(travel);
    		}
    		catch(ParseException e) {
    			return "redirect:/travels";
    		}
    		
    		return "redirect:/travels";
    }
    
    @GetMapping(path="/travels/{id}")
    String editTravel(Map<String, Object> model, @PathVariable String id) {
    		Optional<Travel> travel = repository.findById(id);
    		if(!travel.isPresent()) {
    			return "manage";
    		}
    		model.put("travel", travel.get());
    		return "edit_travel";
    }
}