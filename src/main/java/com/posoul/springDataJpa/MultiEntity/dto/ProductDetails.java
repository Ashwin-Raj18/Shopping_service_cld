package com.posoul.springDataJpa.MultiEntity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class ProductDetails {
	private int pId;
	private String pName;
	private int pQuantity;
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetails(int pId, String pName, int pQuantity) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pQuantity = pQuantity;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	@Override
	public String toString() {
		return "ProductDetails [pId=" + pId + ", pName=" + pName + ", pQuantity=" + pQuantity + "]";
	}
	
	

}
