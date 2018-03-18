package com.sharetravelcosts.manage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sharetravelcosts.travels.Travel;
 
@Controller
public class ManageController {
    @RequestMapping(path="/manage", method=RequestMethod.GET)
    String listTravels(Map<String, Object> model) {
    		ArrayList<Travel> travels = new ArrayList<>();
    		for(int i = 0; i < 3; i++ ) {
	    		Travel travel = new Travel("Dublin", new SimpleDateFormat("29/03/2018"), new SimpleDateFormat("05/04/2018"));
	    		travels.add(travel);
    		}
    		model.put("travels", travels);
        return "manage";
    }
}