package com.assignement.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignement.entities.Account;
import com.assignement.entities.Customer;
import com.assignement.entities.Transaction;
import com.assignement.services.CustomerService;

@RestController
@RequestMapping("/api")
public class MainRestController {

	@Autowired
	CustomerService customerService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getCustomer")
	Customer getCustomer(@RequestParam Integer id) {		
		Customer res = this.customerService.findCustomerById(id);
		return res;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/createAccount")
	@PostMapping void createAccount(@RequestParam Integer id,@RequestParam Integer balance) {
		Customer res = this.customerService.findCustomerById(id);
		Account account = new Account("title", "desc", new Date(), false);
		Transaction transaction = new Transaction(balance,true);
		transaction.setAccount(account);
		account.addTransaction(transaction);
		res.addAccount(account);
		account.setCustomer(res);
		customerService.saveCustomer(res);
	}
}
