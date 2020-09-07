package com.mthree.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mthree.models.Exchange;
import com.mthree.models.Order;
import com.mthree.models.OrderBook;
import com.mthree.models.Sort;
import com.mthree.models.Users;
import com.mthree.services.ExchangeService;
import com.mthree.services.OrderBookService;
import com.mthree.services.OrderService;
import com.mthree.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderBookService orderBookService;
	
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login/{mobileNumber}/{password}")
	public boolean validateLogin(@PathVariable("mobileNumber") String mobileNumber,@PathVariable("password") String password)
	{
		System.out.println();
		
		if(userService.validateLogin(mobileNumber,password)==1)
		{
			if(mobileNumber.equals("admin"))
{
	return true;
}
		return true;  
		}
		else
			return false;
	}
	
	
	@PostMapping("/register")
	public int addUser(@RequestBody Users userData)
	{
		System.out.println(userData.getMobileNumber());
		return userService.addUser(userData);          
	}
	
	
	// http request url to validate user
		@GetMapping("/mobileNumberexists/{mobileNumber}")
		public boolean mobileNumberExists(@PathVariable String mobileNumber)  {
			return userService.mobileNumberExists(mobileNumber);
		}
		
		
		
		@GetMapping("/getUser/{mobileNumber}")
		public Users getUsermobileNumber(@PathVariable String mobileNumber)  {
			return userService.getUsermobileNumber(mobileNumber);
		}
		
		
		
		
	
	@GetMapping("/getAllOrderBooks")
	public List<OrderBook> getAllOrderBooks()
	{
		
     return orderBookService.getAllOrderBooks();
    
	}
	
	
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders()
	{
		
     return orderService.getAllOrders();
    
	}
	
	
	
	
	
	
	@GetMapping("/getOrderbyId/{orderId}")
	public Order getOrderbyId(@PathVariable("orderId") int orderId)
	{
		
     return orderService.getOrderbyId(orderId);
    
	}
	
	
	@GetMapping("/getOrderBookbyId/{orderBookId}")
	public OrderBook getOrderBookbyId(@PathVariable("orderBookId") int orderBookId)
	{
		
     return orderBookService.getOrderBookbyId(orderBookId);
    
	}
	
	
	
	
	
	@PostMapping("/AddOrder/{mobileNumber}")
	public void addOrder(@RequestBody Order order,@PathVariable("mobileNumber") String mobileNumber)
	{
		
     orderService.addOrder(order,mobileNumber);
    
	}
	@GetMapping("/ViewAllOrdersByUserMobileNumber/{mobileNumber}")
	public List<Order> ViewOrder(@PathVariable("mobileNumber") String mobileNumber)
	{
		
     return orderService.viewOrder(mobileNumber);
    
	}
	
	
	
	@PostMapping("/AddOrderBook")
	public void addOrder(@RequestBody OrderBook orderBook)
	{
		
     orderBookService.addOrderBook(orderBook);
    
	}
	
	
	
	@GetMapping("/Delete/{orderId}")
	public void deleteOrder(@PathVariable("orderId") int orderId)
	{
		System.out.println("delete");
     orderService.deleteOrder(orderId);
    
	}
	
	
	
	
	@GetMapping("/getOrdersByOrderBookId/{orderBookId}")
	public List<Order> getOrdersByOderBookId(@PathVariable("orderBookId") int orderBookId)
	{
		
	     return orderBookService.getOrderBookbyId(orderBookId).getOrders();

    
	}
	
	
	
	
	@PostMapping("/AddOrderToOrderBook/{orderBookId}/{orderId}")
	public void addOrderToOrderBook(@PathVariable("orderBookId") int orderBookId,@PathVariable("orderId") int orderId)
	{
		
     orderBookService.addOrderToOrderBook(orderBookId,orderId);
   
	}
	
	
	
	@GetMapping("/getLocalOrderBooks")
	public List<OrderBook> getLocalOrderBooks()
	{
		
  return orderBookService.getLocalOrderBooks();
    
	}
	
	
	
	@GetMapping("/CreateExchanges")
	public void CreateExchanges()
	{
		
      exchangeService.createExchanges();
    
	}
	
	
	@GetMapping("/viewStatus/{orderId}")
	public int viewStatus(@PathVariable("orderId") int orderId)
	{
		
     return orderService.viewStatus(orderId);
    
	}
	
	@GetMapping("/StartSort/{exchangeId}")
	public void startSort(@PathVariable("exchangeId") int exchangeId) throws Exception
	{
		
	List<Exchange> exchanges=new ArrayList<>();
	Exchange exchange=exchangeService.getExchange(exchangeId);
	exchanges.add(exchange);
	List<OrderBook> orderBooks=new ArrayList<>();

	orderBooks.addAll(orderBookService.getLocalOrderBooks());
    System.out.println(orderBooks.get(0).getOrders().size()+"    size");
	Sort sort=new Sort(1,exchanges,orderBooks);
	List<Order> updateOrders=new ArrayList<>();
	updateOrders=sort.ExecuteTrade();
	orderService.updateOrderTable(updateOrders);
	
	}
	
	
	
}