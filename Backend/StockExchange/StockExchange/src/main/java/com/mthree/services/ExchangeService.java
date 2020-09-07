package com.mthree.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.Repositories.CompanyRepository;
import com.mthree.Repositories.ExchangesRepository;
import com.mthree.Repositories.OrderBooksRepository;
import com.mthree.Repositories.OrderRepository;
import com.mthree.models.Company;
import com.mthree.models.Exchange;
import com.mthree.models.Order;
import com.mthree.models.OrderBook;


@Service
public class ExchangeService {

	
	static String[] comapanyNames= {"Amazon","Tata","Flipkart","Wiley","Morgan Stanley"};
	
	 List<Integer> tradeValue= new ArrayList();
		

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderBookService orderBookService;
	
	@Autowired
	private ExchangesRepository exchangeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderBooksRepository orderBookRepository;

	
	public  List<OrderBook> randomGenerate(int exchangeId)
	{
        int totalOrderBooks=orderBookService.getAllOrderBooks().size();
     //   List<Integer> tradeValue= new ArrayList(Arrays.asList(250,467,495,350,300));
		List<OrderBook> orderBooks=new ArrayList<OrderBook>();
		
		for(int k=0;k<5;k++)
		{
			int companyId=k+1;
			
        Random random=new Random();
        int totalOrders=orderService.getAllOrders().size();
        List<Order> orders=new ArrayList<Order>();
        int lowPrice=tradeValue.get(companyId-1)-100;
        int highPrice=tradeValue.get(companyId-1)+50;
//         int lowPrice = exchangeRepository.getOne(exchangeId).getTodaysTradeValue()-100;
//         int highPrice=  exchangeRepository.getOne(exchangeId).getTodaysTradeValue()+50;
//         int lowCompanyId = 1;
//         int highCompanyId = 12;
         int lowNumberOfShares = 5;
         int highNumberOfShares = 100;
         
         for(int j=0;j<5;j++)
         {
        	 Order presentOrder=new Order(totalOrders+j+1,companyId,random.nextInt(highNumberOfShares-lowNumberOfShares) + lowNumberOfShares,
          		   random.nextInt(highPrice-lowPrice) + lowPrice,"sell" );
        	 
           orderRepository.save(presentOrder);
           orders.add(presentOrder);
         }
         
         for(int j=0;j<5;j++)
         {
        	 Order presentOrder=new Order(totalOrders+j+6,companyId,random.nextInt(highNumberOfShares-lowNumberOfShares) + lowNumberOfShares,
            		   random.nextInt(highPrice-lowPrice) + lowPrice,"buy" );
          	 
             orderRepository.save(presentOrder);
             orders.add(presentOrder);

         }
         
         OrderBook presentBook=new OrderBook(totalOrderBooks+k+1,companyId,orders);
         
         orderBooks.add(presentBook);

         orderBookRepository.save(presentBook);
         
		}
	
		
		return orderBooks;
	}


	
	
	public void createExchanges()
	{
		 Random random=new Random();
		   int totalOrderBooks=orderBookService.getAllOrderBooks().size();
			List<Order> orders=new ArrayList<Order>();
			int high=500;
			 int low=250;
			 for(int i=0;i<5;i++) {
			 Company c=new Company(i+1,comapanyNames[i],random.nextInt(high-low)+low);
			 companyRepository.save(c);
				
			 }
			 //  List<Integer> tradeValue= new ArrayList();
				
			   List<Company> c=null;
			   c=companyRepository.findAll();
			 for(Company com:c)
			 {
				 tradeValue.add(com.getTradeValue());
			}
		for(int i=0;i<10;i++)
		{
			 
			Exchange exchange=new Exchange(i+1,null);
			exchangeRepository.save(exchange);
//			exchange.setOrderBooks(generateLocalOrderBook(i+1));
//			exchangeRepository.save(exchange);
			
			exchange.setOrderBooks(randomGenerate(i+1));
			exchangeRepository.save(exchange);
		}
		generateLocalOrderBook();
		
			}
	
	private void generateLocalOrderBook() {
		// TODO Auto-generated method stub
		
		 //List<Integer> tradeValue= new ArrayList(Arrays.asList(250,467,495,350,300));
	 int totalOrderBooks=orderBookService.getAllOrderBooks().size();
      
//			List<OrderBook> orderBooks=new ArrayList<OrderBook>();
	 for(int k=0;k<5;k++)
		{
			int companyId=k+1;
		
			
	        Random random=new Random();
	       int totalOrders=orderService.getAllOrders().size();
	        List<Order> orders=new ArrayList<Order>();
	        int lowPrice=tradeValue.get(companyId-1)-100;
	        int highPrice=tradeValue.get(companyId-1)+50;
//	         int lowPrice = exchangeRepository.getOne(exchangeId).getTodaysTradeValue()-100;
//	         int highPrice=  exchangeRepository.getOne(exchangeId).getTodaysTradeValue()+50;
//	         int lowCompanyId = 1;
//	         int highCompanyId = 12;
	         int lowNumberOfShares = 5;
	         int highNumberOfShares = 100;
	         
	         for(int j=0;j<5;j++)
	         {
	        	 Order presentOrder=new Order(totalOrders+j+1,companyId,random.nextInt(highNumberOfShares-lowNumberOfShares) + lowNumberOfShares,
	          		   random.nextInt(highPrice-lowPrice) + lowPrice,"sell" );
	        	 
	           orderRepository.save(presentOrder);
	           orders.add(presentOrder);
	         }
	         
	         for(int j=0;j<5;j++)
	         {
	        	 Order presentOrder=new Order(totalOrders+j+6,companyId,random.nextInt(highNumberOfShares-lowNumberOfShares) + lowNumberOfShares,
	            		   random.nextInt(highPrice-lowPrice) + lowPrice,"buy" );
	          	 
	             orderRepository.save(presentOrder);
	             orders.add(presentOrder);

	         }
		
			 OrderBook presentBook=new OrderBook(totalOrderBooks+k+1,companyId,orders);
		        
			 orderBookRepository.save(presentBook);
		 
//	         List<OrderBook> l=new ArrayList<>();
//	         l.add(presentBook);
		}  
            		
	}




	public Exchange getExchange(int exchangeId)
	{
		if(exchangeRepository.existsById(exchangeId))
		return exchangeRepository.findById(exchangeId).get();
		else
			return null;
	}
	
}
