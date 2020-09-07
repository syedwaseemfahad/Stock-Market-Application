package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderTable1")
public class Order {

	@Id
	int orderId;
	int share_companyId;
	int noOfShares;
	int price;
	String type;
	
	
	
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", share_companyId=" + share_companyId + ", noOfShares=" + noOfShares
				+ ", price=" + price + ", type=" + type + "]";
	}



	public Order(int orderId, int share_companyId, int noOfShares, int price, String type) {
		super();
		this.orderId = orderId;
		this.share_companyId = share_companyId;
		this.noOfShares = noOfShares;
		this.price = price;
		this.type = type;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getShare_companyId() {
		return share_companyId;
	}



	public void setShare_companyId(int share_companyId) {
		this.share_companyId = share_companyId;
	}



	public int getNoOfShares() {
		return noOfShares;
	}



	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
