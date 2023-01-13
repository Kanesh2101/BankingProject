package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer>
{
	
	Customer findByName(String name);
	
	@Query("from Customer where name =?1 ")
	Customer findByNameSorted(String name);

}
