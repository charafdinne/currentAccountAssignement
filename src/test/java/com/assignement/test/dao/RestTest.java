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

import com.assignement.entities.AccountCreationBody;
import com.assignement.resources.MainRestController;
import com.assignement.services.CustomerService;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestTest {

	@Autowired
	MainRestController mainRestController;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void injectedComponentsAreNotNull() {
		assertNotNull(mainRestController);
	}
	
	@Test
	public void getcustomerTest() {
		assertEquals(assertDoesNotThrow(() -> this.mainRestController.getCustomer(Integer.valueOf(1)).getName()),"name");
	}
	
	@Test
	public void createAccountTest() {
		assertDoesNotThrow(() -> this.mainRestController.createAccount(new AccountCreationBody(Integer.valueOf(1),500)));
	}
}
