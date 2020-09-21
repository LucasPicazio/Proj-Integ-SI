package com.example.demo.data.entity.repository;

import com.example.demo.data.entity.Reservation;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	// Spring data will build the query for us based on the name of the method that we're creating
	Iterable<Reservation> findReservationByReservationDate(Date date);
	
}
