package com.pisi.marketplace.data.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pisi.marketplace.data.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	// Spring data will build the query for us based on the name of the method that we're creating
	//Iterable<Product> findReservationByReservationDate(Date date);
	
}
