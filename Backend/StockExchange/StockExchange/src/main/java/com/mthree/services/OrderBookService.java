package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.Repositories.OrderBooksRepository;
import com.mthree.models.OrderBook;

@Service
public class OrderBookService {

	
	
	
	@Autowired
	private  OrderBooksRepository orderBookRepository;
	
	
	@Autowired
	private OrderService orderService;
	

	public void addOrderBook(OrderBook orderBook)
	{
		
	orderBookRepository.save(orderBook);
	
	}
	
	
	public void addOrderToOrderBook(int orderBookId,int orderId)
	{
	orderBookRepository.findById(orderBookId).get().getOrders().add(orderService.getOrderbyId(orderId));
	orderBookRepository.save(getOrderBookbyId(orderBookId));
	}


	public OrderBook getOrderBookbyId(int orderBookId) {
		if(orderBookRepository.existsById(orderBookId))
	
		return orderBookRepository.findById(orderBookId).get();
		else
			return null;
	}
	
   public List<OrderBook> getAllOrderBooks() {
		
		return orderBookRepository.findAll();
	}

   public  List<OrderBook> getLocalOrderBooks() {
	
	   System.out.println(orderBookRepository.getLocalOrderBooks().size()+"                             gfhhjkbhgfhjhgcfxdxghvbjhvgfdgxhjgyft");
	return orderBookRepository.getLocalOrderBooks();
}


   

}

	