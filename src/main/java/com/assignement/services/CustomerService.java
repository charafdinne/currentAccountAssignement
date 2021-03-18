package com.assignement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignement.dao.CustomerRepository;
import com.assignement.entities.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Transactional(readOnly = true)
	public Customer findCustomerById(Integer id) {
		return customerRepository.findById(id).get();
	}
}
