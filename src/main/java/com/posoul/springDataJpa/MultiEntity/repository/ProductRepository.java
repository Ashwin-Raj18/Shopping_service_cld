package com.posoul.springDataJpa.MultiEntity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posoul.springDataJpa.MultiEntity.entities.Customer;
import com.posoul.springDataJpa.MultiEntity.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCustomer(Customer customer);
}
