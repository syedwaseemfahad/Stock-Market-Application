package com.mthree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.models.Exchange;
import com.mthree.models.Order;
import com.mthree.models.OrderBook;
import com.mthree.models.Users;
import com.mthree.services.ExchangeService;
import com.mthree.services.OrderBookService;
import com.mthree.services.OrderService;
import com.mthree.services.UserService;

@SpringBootTest
class StockExchangeApplicationTests {

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderBookService orderBookService;
	
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private UserService userService;
	//User Service Test Cases
	
	
	//Test case for valid user details
	@Test
	void contextLoads() {
		int i=userService.validateLogin("9092435259","123456");
		assertEquals(1, i);
	}
	//Test case for invalid user details
	@Test
	void contextLoads2() {
		int i=userService.validateLogin("9876543210","user2");
		assertEquals(0, i);
	}
	// Test case for wrong password
	@Test
	void contextLoads8() {
		int i=userService.validateLogin("6305675146","user2");
		assertEquals(0, i);
	}
	// Test case for wrong phone number
	@Test
	void contextLoads20() {
		int i=userService.validateLogin("6305675145","user2");
		assertEquals(0, i);
	}
    
	
    // Test case for checking whether a mobile number exists 
	@Test
	void contextLoads12() {
		boolean i=userService.mobileNumberExists("9092435259");
		assertEquals(false, i);
	}

    // Test case for checking whether a mobile number not exists 
	@Test
	void contextLoads13() {
		boolean i=userService.mobileNumberExists("6305675145");
		assertEquals(true, i);
	}

    // Test case for getting user based on existing mobile number 
	@Test
	void contextLoads14() {
		Users i=userService.getUsermobileNumber("9092435259");
		assertNotNull(i);	
		}
	 // Test case for getting user based on mobile number(not existing) 
	@Test
	void contextLoads15() {
		Users i=userService.getUsermobileNumber("6305675145");
		assertNull(i);	
		}

	
	// Test Only once (from second time uncomment @Disabled)

	@Test
	//@Disabled
	void contextLoads1() {
		Users u=new Users(22,"user22","9092435258","user22","user22@gmail.com",null);
		int i=userService.addUser(u);
		assertEquals(1,i);
	}
	
	
	
	//Order Service Test cases
	
	@Test
	@Disabled
	void contextLoads3() {
		int i=orderService.viewStatus(100);
		assertEquals(1,i);
	}
	
	@Test
	//@Disabled
	void contextLoads21() {
		int i=orderService.viewStatus(100);
		assertEquals(0,i);
	}
	
	@Test
	void contextLoads4() {
			Order i=orderService.getOrderbyId(100);
		assertNotNull(i);
	}
	
	@Test
	void contextLoads17() {
			Order i=orderService.getOrderbyId(1000);
		assertNull(i);
	}

	// View order details 
	@Test
	void contextLoads5() {
			List<Order> i=orderService.viewOrder("9092435259");
			
		assertNotNull(i);
	}
	// View order details 
		@Test
		void contextLoads16() {
				List<Order> i=orderService.viewOrder("6305675145");
				
			assertNull(i);
		}
		
	
	
	
	@Test
	void contextLoads0() {
			List<Order> i=orderService.getAllOrders();
			
		assertNotNull(i);
	}
	
	
	//OrderBookService test cases
	@Test
	void contextLoads6() {
		List<OrderBook> i=orderBookService.getLocalOrderBooks();				
		assertNotNull(i);
	}
	@Test
	void contextLoads10() {
		List<OrderBook> i=orderBookService.getAllOrderBooks()	;		
		assertNotNull(i);
	}
	
	@Test
	void contextLoads19() {
		OrderBook i=orderBookService.getOrderBookbyId(100);		
		assertNull(i);
	}
	
	@Test
	void contextLoads11() {
		OrderBook i=orderBookService.getOrderBookbyId(1);		
		assertNotNull(i);
	}
	
	
	//ExchangeService test cases
	@Test
	void contextLoads7() {
	Exchange i=exchangeService.getExchange(1);				
		assertNotNull(i);
	}
	
	@Test
	void contextLoads22() {
	Exchange i=exchangeService.getExchange(11);				
		assertNull(i);
	}
	
	
	
	

}
