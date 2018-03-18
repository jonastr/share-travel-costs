package com.sharetravelcosts.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sharetravelcosts.entities.Travel;
import com.sharetravelcosts.storage.TravelRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TravelRepository repository;
	
	@Test
	public void indexRedirects() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void listsTravels() throws Exception {
		List<Travel> travels = new ArrayList<>();
		travels.add(new Travel("foo", new Date(), new Date()));
		travels.add(new Travel("bar", new Date(), new Date()));
		
		given(repository.findAll()).willReturn(travels);
		
		this.mvc.perform(get("/travels"))
			.andExpect(status().is2xxSuccessful())
			.andExpect(content().string(containsString("foo")))
			.andExpect(content().string(containsString("bar")));
	}
}