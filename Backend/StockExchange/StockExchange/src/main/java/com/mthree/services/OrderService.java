package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.Repositories.OrderBooksRepository;
import com.mthree.Repositories.OrderRepository;
import com.mthree.Repositories.UserRepository;
import com.mthree.models.Order;
import com.mthree.models.OrderBook;
import com.mthree.models.Users;

@Service
//@SessionAttributes("userId")

public class OrderService {

	@Autowired
	private OrderBooksRepository orderBookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Order order,String mobileNumber)
	{
		
	order.setOrderId(1+Integer.parseInt(orderRepository.getMaxId().toString()));
	List<OrderBook>	orderBooks=orderBookRepository.getLocalOrderBooks();
		for(int i=0;i<orderBooks.size();i++)
		{
           if(orderBooks.get(i).getCompany_id()==order.getShare_companyId())
           {
        	   orderBooks.get(i).getOrders().add(order); 
        	   orderBookRepository.save(orderBooks.get(i));
           }
		}
		 
   List<Users>	users=userRepository.findAll();	
   for(int i=0;i<users.size();i++)
   {
	   if(users.get(i).getMobileNumber().equals(mobileNumber))
	   {
		   users.get(i).getOrders().add(order);
		    userRepository.save(users.get(i));  
	   }
   }
	
    
	}

	
	
		
	
	
public Order getOrderbyId(int orderId) {
	
	    if(orderRepository.existsById(orderId))
		
		return orderRepository.findById(orderId).get();
	    
	    else
	    	return null;
	}


public List<Order> getAllOrders() {
	
	return orderRepository.findAll();
}

public void updateOrderTable(List<Order> updateOrders)
{
	orderRepository.saveAll(updateOrders);
}



public void deleteOrder(int orderId) {
	
	orderRepository.deleteById(orderId);
	
}



public List<Order> viewOrder(String mobileNumber) {
	// TODO Auto-generated method stub))
	
	
	List<Users>	users=userRepository.findAll();	
	   for(int i=0;i<users.size();i++)
	   {
		   if(users.get(i).getMobileNumber().equals(mobileNumber))
		   {
				return users.get(i).getOrders();

		   }
	   }
	
	return null;
	

}



public int viewStatus(int orderId) {
	
	if(orderRepository.findNoOfShares(orderId)==0)
		return 1;
	// TODO Auto-generated method stub
	else
	return 0;
}

}

	
	