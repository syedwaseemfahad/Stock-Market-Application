package com.mthree.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Users;


	
	@Repository
	public interface UserRepository extends JpaRepository<Users,Integer>  {

		
		
		
		
	}

