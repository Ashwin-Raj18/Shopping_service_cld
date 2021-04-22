package com.posoul.springDataJpa.MultiEntity.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue // values will be auto generated
	private int custId;
	private String name;
	private String email;
	private String gender;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade = CascadeType.ALL) //persist will try to update
	private List<Product> products;
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.setCustomer(this);	
	}
}
