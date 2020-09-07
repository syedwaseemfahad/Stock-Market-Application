package com.mthree.models;

import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Exchange {

	@Id
	int exchangeID;

	
	
	@OneToMany(targetEntity = OrderBook.class,cascade = CascadeType.ALL)
	@JoinColumn(name="eo_fk",referencedColumnName = "exchangeID")
	List<OrderBook> orderBooks;
//	int todaysTradeValue;
	
	
	
	




	public Exchange(int exchangeID, List<OrderBook> orderBooks) {
		super();
		this.exchangeID = exchangeID;
		
		this.orderBooks = orderBooks;
		//this.todaysTradeValue = todaysTradeValue;
	}




	@Override
	public String toString() {
		return "Exchange [exchangeID=" + exchangeID + ", orderBooks=" + orderBooks + "]";
	}




	public int getExchangeID() {
		return exchangeID;
	}




	public void setExchangeID(int exchangeID) {
		this.exchangeID = exchangeID;
	}





	public List<OrderBook> getOrderBooks() {
		return orderBooks;
	}




	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}




//	public int getTodaysTradeValue() {
//		return todaysTradeValue;
//	}
//
//
//
//
//	public void setTodaysTradeValue(int todaysTradeValue) {
//		   
//		this.todaysTradeValue =todaysTradeValue ;
//	}




	public Exchange() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
