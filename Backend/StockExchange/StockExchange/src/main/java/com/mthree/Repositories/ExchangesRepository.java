package com.mthree.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Exchange;




@Repository
public interface ExchangesRepository extends JpaRepository<Exchange,Integer> {

	
	
	
	
}