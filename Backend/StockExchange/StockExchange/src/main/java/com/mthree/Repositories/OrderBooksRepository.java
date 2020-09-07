package com.mthree.Repositories;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.models.OrderBook;




@Repository
public  interface OrderBooksRepository extends JpaRepository<OrderBook,Integer> {

	
	
	@Query(value = "select * from Order_Book where EO_FK is null", nativeQuery = true)
	public List<OrderBook> getLocalOrderBooks();

	
	
	//public List<OrderBook> getAllLocalOrderBooks();

	
	
}
