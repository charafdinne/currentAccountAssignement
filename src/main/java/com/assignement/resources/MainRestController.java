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
import com.assignement.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MainRestController {

	Logger logger = LoggerFactory.getLogger(MainRestController.class);

	@Autowired
	CustomerService customerService;

	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam Integer id) throws Exception {
		if (id == null) {
			logger.error("cutsomer Id cannot be null");
			throw new Exception("cutsomer Id cannot be null");
		}
		Customer res = this.customerService.findCustomerById(id);
		logger.info("found customer for id : " + id + " : " + res);
		return res;
	}

	@PostMapping("/createAccount")
	public Customer createAccount(@RequestBody AccountCreationBody body) throws Exception {
		if (body.getCustomerId() == null) {
			logger.error("cutsomer Id cannot be null");
			throw new Exception("cutsomer Id cannot be null");
		}
		Customer res = this.customerService.findCustomerById(body.getCustomerId());
		Account account = new Account("title", "desc", new Date(), false);
		if (body.getBalance() == null)
			throw new Exception("balance cannot be null");
		if (body.getBalance() == 0)
			return res;
		Transaction transaction = new Transaction(body.getBalance(), true);
		transaction.setAccount(account);
		account.addTransaction(transaction);
		res.addAccount(account);
		account.setCustomer(res);
		customerService.saveCustomer(res);
		logger.info("created new account and added new transaction with provided balance");
		return res;
	}
}
