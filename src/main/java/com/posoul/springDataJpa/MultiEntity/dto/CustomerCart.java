package com.posoul.springDataJpa.MultiEntity.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class CustomerCart {
	private String customerName;
	private int cId;
	private List<ProductDetails> pDetails;
	public CustomerCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerCart(String customerName, int cId, List<ProductDetails> pDetails) {
		super();
		this.customerName = customerName;
		this.cId = cId;
		this.pDetails = pDetails;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public List<ProductDetails> getpDetails() {
		return pDetails;
	}
	public void setpDetails(List<ProductDetails> pDetails) {
		this.pDetails = pDetails;
	}
	@Override
	public String toString() {
		return "CustomerCart [customerName=" + customerName + ", cId=" + cId + ", pDetails=" + pDetails + "]";
	}
	
}
