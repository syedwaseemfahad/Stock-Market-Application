
package com.mthree.DTOs;

import java.util.List;

import com.mthree.models.Order;

public class UpdatedAndExecutedOrders {

	List<ExecutedOrder> executedOrders;
	List<Order>  updatedSellerOrders;
	List<Order>  updatedBuyerOrders;
	public List<ExecutedOrder> getExecutedOrders() {
		return executedOrders;
	}
	public void setExecutedOrders(List<ExecutedOrder> executedOrders) {
		this.executedOrders = executedOrders;
	}
	public List<Order> getUpdatedSellerOrders() {
		return updatedSellerOrders;
	}
	public void setUpdatedSellerOrders(List<Order> updatedSellerOrders) {
		this.updatedSellerOrders = updatedSellerOrders;
	}
	public List<Order> getUpdatedBuyerOrders() {
		return updatedBuyerOrders;
	}
	public void setUpdatedBuyerOrders(List<Order> updatedBuyerOrders) {
		this.updatedBuyerOrders = updatedBuyerOrders;
	}
	@Override
	public String toString() {
		return "UpdatedAndExecutedOrders [executedOrders=" + executedOrders + ", updatedSellerOrders="
				+ updatedSellerOrders + ", updatedBuyerOrders=" + updatedBuyerOrders + "]";
	}
	
	public UpdatedAndExecutedOrders(List<ExecutedOrder> executedOrders, List<Order> updatedSellerOrders,
			List<Order> updatedBuyerOrders) {
		super();
		this.executedOrders = executedOrders;
		this.updatedSellerOrders = updatedSellerOrders;
		this.updatedBuyerOrders = updatedBuyerOrders;
	}
	
	public UpdatedAndExecutedOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
