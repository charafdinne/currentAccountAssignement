package com.assignement.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignement.entities.Account;
import com.assignement.entities.AccountCreationBody;
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
	Customer getCustomer(@RequestParam Integer id) throws DAOException {		
		Customer res = this.customerService.findCustomerById(id);
		return res;
	}
	
	@PostMapping("/createAccount")
	Customer createAccount(@RequestBody AccountCreationBody body) throws Exception {
		Customer res = this.customerService.findCustomerById(body.getCustomerId());
		Account account = new Account("title", "desc", new Date(), false);
		if(body.getBalance() == null)
			throw new Exception("balance cannot be null");
		Transaction transaction = new Transaction(body.getBalance(),true);
		transaction.setAccount(account);
		account.addTransaction(transaction);
		res.addAccount(account);
		account.setCustomer(res);
		customerService.saveCustomer(res);
		return res;
	}
}
