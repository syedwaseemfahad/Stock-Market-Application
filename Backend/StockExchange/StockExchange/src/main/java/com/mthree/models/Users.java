package com.mthree.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
	@Id
	private int userId;
	private String userName;
	private String mobileNumber;
    
	private String password,email;
	   
	
	
	@OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
	@JoinColumn(name="user_fk",referencedColumnName = "userId")
	List<Order> orders;

     
	
	
	
	
	public int getUserId() {
		return userId;
	}






	public void setUserId(int userId) {
		this.userId = userId;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getMobileNumber() {
		return mobileNumber;
	}






	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public List<Order> getOrders() {
		return orders;
	}


	
	




	public void setOrders(List<Order> orders) {
		
		this.orders = orders;
		
	}






	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber + ", password="
				+ password + ", email=" + email + ", orders=" + orders + "]";
	}






	public Users(int userId, String userName, String mobileNumber, String password, String email, List<Order> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
		this.orders = orders;
	}






	public Users() {
		
	}
	

}
