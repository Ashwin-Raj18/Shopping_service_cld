package com.posoul.springDataJpa.MultiEntity.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

	@Id
	@GeneratedValue
	private int pId;
	private String productName;
	private int quantity;
	private int price;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="cust_id_fk",referencedColumnName = "custId")
	private Customer customer;

	
}
