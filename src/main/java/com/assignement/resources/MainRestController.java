package com.assignement.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignement.entities.Customer;
import com.assignement.services.CustomerService;

@RestController
@RequestMapping("/api")
public class MainRestController {
	
	@Autowired 
	CustomerService customerService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getCustomer")
	Customer getCustomer(@RequestParam Integer id) {
		return this.customerService.findCustomerById(id);
	}
}
