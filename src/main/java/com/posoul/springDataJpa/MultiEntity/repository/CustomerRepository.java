package com.posoul.springDataJpa.MultiEntity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.posoul.springDataJpa.MultiEntity.entities.Customer;
import com.posoul.springDataJpa.MultiEntity.entities.Product;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
		//here com.posoul.springDataJpa.MultiEntity.dto.OrderResponse(c.name , p.productName) is a constructor
	   @Query("SELECT new com.posoul.springDataJpa.MultiEntity.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
	    public List<?> getJoinInformation();
	   
	   
	   public List<Customer> findProductsByCustId(int id);
}