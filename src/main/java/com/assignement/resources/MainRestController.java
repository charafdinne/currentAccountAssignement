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
import com.assignement.exceptions.DAOException;
import com.assignement.services.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MainRestController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/getCustomer")
	Customer getCustomer(@RequestParam String id) throws DAOException {		
		Customer res = this.customerService.findCustomerById(Integer.valueOf(id));
		return res;
	}
	
	@GetMapping("/createAccount")
	@PostMapping void createAccount(@RequestParam Integer id,@RequestParam Integer balance) throws DAOException {
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
