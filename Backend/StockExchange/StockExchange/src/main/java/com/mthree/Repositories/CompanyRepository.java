package com.mthree.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>  {

	

}
