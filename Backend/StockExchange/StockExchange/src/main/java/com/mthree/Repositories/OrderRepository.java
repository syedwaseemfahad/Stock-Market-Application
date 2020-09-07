package com.mthree.Repositories;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.models.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>  {
	@Query(value = "update order_table set obo_fk= 0,user_fk=:userId where order_id=:orderId", nativeQuery = true)
	@Modifying
	@Transactional

	
	public void updateObofk(@Param("orderId") int orderId,@Param("userId") int userId);

	@Query(value = "select * from order_table where user_fk=:userId", nativeQuery = true)
	
	public List<Order> findAllOrdersByUserId(@Param("userId") int userId);

	
	@Query("select noOfShares from Order where orderId=:orderId")
	public int findNoOfShares(@Param("orderId") int orderId);

	
	@Query("SELECT max(ch.orderId) FROM Order ch")
	Long getMaxId();
	
	
}