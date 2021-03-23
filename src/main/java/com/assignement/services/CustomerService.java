package com.assignement.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignement.dao.CustomerRepository;
import com.assignement.entities.Customer;
import com.assignement.exceptions.DAOException;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Transactional(readOnly = true)
	public Customer findCustomerById(Integer id) throws DAOException {
		Customer res = null;
		try {
			res = customerRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new DAOException("404", "No customer found for provided ID : " + id + e.getMessage());
		}
		return res;
	}

	@Transactional
	public void saveCustomer(Customer customer) throws DAOException {
		customer = this.customerRepository.save(customer);
		if (customer == null)
			throw new DAOException("500", "cannot persist customer something went wrong");
	}
}
