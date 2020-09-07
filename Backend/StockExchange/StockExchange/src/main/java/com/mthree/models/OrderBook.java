package com.mthree.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class OrderBook {
	
	@Id
	int orderBookId;
	int company_id;
	@OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
	@JoinColumn(name="obo_fk",referencedColumnName = "orderBookId")
	List<Order> orders;

	
	
	public OrderBook(int orderBookId, int company_id, List<Order> orders) {
		super();
		this.orderBookId = orderBookId;
		this.company_id = company_id;
		this.orders = orders;
	}

	
	@Override
	public String toString() {
		return "OrderBook [orderBookId=" + orderBookId + ", company_id=" + company_id + ", orders=" + orders + "]";
	}


	public int getOrderBookId() {
		return orderBookId;
	}

	public int getCompany_id() {
		return company_id;
	}


	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}


	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void newOrder(Order order)
	{
		this.orders.add(order);
	}
	
	
	public void cancelOrder(int order_id)
	{
		this.orders.remove(order_id);
	}
	

}
