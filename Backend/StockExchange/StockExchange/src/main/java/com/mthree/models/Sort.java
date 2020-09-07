package com.mthree.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mthree.DTOs.ExecutedOrder;
import com.mthree.DTOs.UpdatedAndExecutedOrders;
import com.mthree.services.OrderBookService;
import com.mthree.services.OrderService;





public class Sort {
	
	@Autowired
	private static OrderBookService orderBookService;
	
    int sortId;
	
	List<Exchange> exchanges;
	
	List<OrderBook> orderBook;

	
	public int getSortId() {
		return sortId;
	}


	public void setSortId(int sortId) {
		this.sortId = sortId;
	}


	public List<Exchange> getExchanges() {
		return exchanges;
	}


	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}


	public List<OrderBook> getOrderBook() {
		return orderBook;
	}


	public void setOrderBook(List<OrderBook> orderBook) {
		this.orderBook = orderBook;
	}

	
	

	public Sort(int sortId, List<Exchange> exchanges, List<OrderBook> orderBook) {
		super();
		this.sortId = sortId;
		this.exchanges = exchanges;
		this.orderBook = orderBook;
	}


	@Override
	public String toString() {
		return "Sort [sortId=" + sortId + ", exchanges=" + exchanges + ", orderBook=" + orderBook + "]";
	}


	public Sort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static boolean exchangeStart=false;
	
	public   List<Order> ExecuteTrade() throws Exception
	{
		List<Order> localOrders=new ArrayList<Order>();
		List<OrderBook> LocalOrderBooks =new ArrayList<OrderBook>();
        LocalOrderBooks.addAll(this.getOrderBook());
		for(int i=0;i<LocalOrderBooks.size();i++)
		{
			localOrders.addAll(LocalOrderBooks.get(i).getOrders());	
			System.out.println("local orders:  "+LocalOrderBooks.get(i).getOrders());
		}
        

        //InternalCrossing

		
		 List<Order> globalUpdatedSellerOrders=new ArrayList<Order>();
		 List<Order> globalUpdatedBuyerOrders=new ArrayList<Order>();
	     List<ExecutedOrder> globalExecutedOrders=new ArrayList<ExecutedOrder>();

        
        
        for(int j=1;j<=11;j++)
        {
        
        
        List<Order> sellOrders=new ArrayList<Order>();
        List<Order> buyOrders=new ArrayList<Order>();
        int sell=0;
        int buy=0;
        System.out.println(localOrders.size());
        for(int i=0;i<localOrders.size();i++)
        {
        	if(localOrders.get(i).getType().equals("sell") && localOrders.get(i).getShare_companyId()==j)
        	{
        		sellOrders.add(localOrders.get(i));
        		sell++;
        	}
        	else if(localOrders.get(i).getType().equals("buy")&&localOrders.get(i).getShare_companyId()==j)
        	{
        		buyOrders.add(localOrders.get(i));	
        		buy++;
        	}
        }
        //System.out.println(sell+" "+buy+"  company"+j);
        UpdatedAndExecutedOrders updatedAndExecutedOrders=exchangeStocks(sellOrders,buyOrders);
        List<ExecutedOrder> executedOrders=updatedAndExecutedOrders.getExecutedOrders();
        List<Order> updatedSellerOrders=updatedAndExecutedOrders.getUpdatedSellerOrders();
        List<Order> updatedBuyerOrders=updatedAndExecutedOrders.getUpdatedBuyerOrders();
        globalUpdatedSellerOrders.addAll(updatedSellerOrders);
        globalUpdatedBuyerOrders.addAll(updatedBuyerOrders);
        globalExecutedOrders.addAll(executedOrders);

       
        
        }
        
        
//        
//       for(int i=0;i<globalUpdatedSellerOrders.size();i++)
//       {
//       	System.out.println(globalUpdatedSellerOrders.get(i));
//
//       }
//       
//       for(int i=0;i<globalUpdatedBuyerOrders.size();i++)
//       {
//       	System.out.println(globalUpdatedBuyerOrders.get(i));
//       }
//        
       
       for(int i=0;i<globalExecutedOrders.size();i++)
       {
       	System.out.println(globalExecutedOrders.get(i));
       }
       
       
       for(int i=0;i<8;i++)
       {
    	   System.out.println("");
       }
        //After Internal Crossing Exchanges come into picture
        
        //Load all orders from the Exchanges
        
       exchangeStart=true;
        
        List<Order>   exchangeSellerOrders=new ArrayList<Order>();
        List<Order>   exchangeBuyerOrders=new ArrayList<Order>();

		for(int i=0;i<this.exchanges.size();i++)
		{
			for(int j=0;j<this.exchanges.get(i).getOrderBooks().size();j++)
			{
				for(int k=0;k<this.exchanges.get(i).getOrderBooks().get(j).getOrders().size();k++)
				{
					if(this.exchanges.get(i).getOrderBooks().get(j).getOrders().get(k).getType().equals("sell"))
					{
					exchangeSellerOrders.add(this.exchanges.get(i).getOrderBooks().get(j).getOrders().get(k));
					}
					else
					{
					  exchangeBuyerOrders.add(this.exchanges.get(i).getOrderBooks().get(j).getOrders().get(k));
					}
				}
			}
		}
		
		
		
		Collections.sort(globalUpdatedSellerOrders,new SortbyPrice());
		Collections.sort(globalUpdatedBuyerOrders,new SortbyPrice());
		Collections.sort(exchangeSellerOrders,new SortbyPrice());
		Collections.sort(exchangeBuyerOrders,new SortbyPrice());

		

		UpdatedAndExecutedOrders updatedAndExecutedOrdersFromExchange1=exchangeStocks(exchangeSellerOrders,globalUpdatedBuyerOrders);
		UpdatedAndExecutedOrders updatedAndExecutedOrdersFromExchange2=exchangeStocks(globalUpdatedSellerOrders,exchangeBuyerOrders);
        
	     List<ExecutedOrder> ExecutedOrdersThroughExchange=updatedAndExecutedOrdersFromExchange1.getExecutedOrders();
	     ExecutedOrdersThroughExchange.addAll(updatedAndExecutedOrdersFromExchange2.getExecutedOrders());
	     
	     
	     for(int i=0;i<ExecutedOrdersThroughExchange.size();i++)
	       {
	       	System.out.println(ExecutedOrdersThroughExchange.get(i));
	       }
	     
	     
	     List<Order>  updatedBuyerOrdersThroughExchange=updatedAndExecutedOrdersFromExchange1.getUpdatedBuyerOrders();

	     List<Order>  updatedSellerOrdersThroughExchange=updatedAndExecutedOrdersFromExchange2.getUpdatedSellerOrders();
	     
	     globalExecutedOrders.addAll(ExecutedOrdersThroughExchange);
	     
        
	     List<Order> globalUpdatedOrders=new ArrayList<Order>();
	     globalUpdatedOrders.addAll(globalUpdatedSellerOrders);
	     globalUpdatedOrders.addAll(globalUpdatedBuyerOrders);
	     
			
	     
	     return globalUpdatedOrders;
	     
        
        
	}
	
	
	
	 public   UpdatedAndExecutedOrders exchangeStocks( List<Order> sellers,List<Order> buyers) throws Exception
	    {
		 //System.out.println(sellers.size()+buyers.size()+"            total");
		
	        ArrayList<ExecutedOrder> executedOrders=new ArrayList<>();
	        Collections.sort(sellers,new SortbyPrice());
	        Collections.sort(buyers,new SortbyPrice());
         int seller_index=sellers.size()-1;
         int buyer_index=buyers.size()-1;
         while(buyer_index>=0 && seller_index>=0)
         {
             boolean execution=false;
         	while(!execution && buyer_index>=0 && seller_index>=0)
         	{
         	
         	if(sellers.get(seller_index).getNoOfShares()!=0  && buyers.get(buyer_index).getNoOfShares()!=0   &&  sellers.get(seller_index).getPrice() <= buyers.get(buyer_index).getPrice() && sellers.get(seller_index).getShare_companyId()==buyers.get(buyer_index).getShare_companyId())
         	{
         		int commision=0;
         		if(exchangeStart)
         		{
         		commision=buyers.get(buyer_index).getPrice()*FeeLadder.caluculateFeePercentage(buyers.get(buyer_index).getPrice(),Math.min(sellers.get(seller_index).getNoOfShares(),buyers.get(buyer_index).getNoOfShares()))/1000;
         		}
         		
         		executedOrders.add(new ExecutedOrder(sellers.get(seller_index).orderId,buyers.get(buyer_index).getOrderId(),sellers.get(seller_index).getPrice(),
         	    buyers.get(buyer_index).getPrice(),sellers.get(seller_index).getShare_companyId(),Math.min(sellers.get(seller_index).getNoOfShares(),buyers.get(buyer_index).getNoOfShares()),commision));
         		execution=true;
         		if(sellers.get(seller_index).getNoOfShares() < buyers.get(buyer_index).getNoOfShares())
         		{
         			buyers.get(buyer_index).setNoOfShares(buyers.get(buyer_index).getNoOfShares()-sellers.get(seller_index).getNoOfShares());
         			sellers.get(seller_index).setNoOfShares(0);
         			seller_index--;
         		}
         		else if(sellers.get(seller_index).getNoOfShares() > buyers.get(buyer_index).getNoOfShares())
         		{
         			sellers.get(seller_index).setNoOfShares(sellers.get(seller_index).getNoOfShares()-buyers.get(buyer_index).getNoOfShares());
         			buyers.get(buyer_index).setNoOfShares(0);
                 	buyer_index--;

         		}
         		else if(sellers.get(seller_index).getNoOfShares() == buyers.get(buyer_index).getNoOfShares())
         		{
         			sellers.get(seller_index).setNoOfShares(0);
         			buyers.get(buyer_index).setNoOfShares(0);
         			buyer_index--;
         			seller_index--;
         		}
         	}
         	else
         	{
         		seller_index--;
         	}
     		

         	}
         	
         }
         UpdatedAndExecutedOrders updatedAndExecutedOrders=new  UpdatedAndExecutedOrders(executedOrders,sellers,buyers);
	       return (updatedAndExecutedOrders);
	    }
		
}
class SortbyPrice implements Comparator<Order> 
{ 
	
    @Override 
    public int compare(Order a, Order b) 
    { 
        return a.price - b.price; 
    }
    
} 




