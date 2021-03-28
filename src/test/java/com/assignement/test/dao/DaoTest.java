package com.assignement.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignement.entities.Customer;
import com.assignement.services.CustomerService;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTest {

	@Autowired
	CustomerService customerService;

	@Test
	public void injectedComponentsAreNotNull() {
		assertNotNull(customerService);
	}
	
	@Test
	public void customerServiceTest() {
		assertDoesNotThrow(() -> customerService.findCustomerById(Integer.valueOf(1)));
		assertDoesNotThrow(() -> customerService.saveCustomer(new Customer("testcustomer","testcustomer","testcustomre")));
		assertEquals(assertDoesNotThrow(() -> customerService.finCustomrByName("testcustomer").getName()), "testcustomer");
	}
}
