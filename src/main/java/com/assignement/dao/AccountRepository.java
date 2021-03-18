package com.assignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignement.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	
}
