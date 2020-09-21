package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entity.Reservation;
import com.example.demo.data.entity.Room;
import com.example.demo.data.entity.repository.ReservationRepository;
import com.example.demo.data.entity.repository.RoomRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	
	/*
	@RestController
	@RequestMapping("/rooms")
	public class RoomController {
		@Autowired
		private RoomRepository roomRepository;
		
		@GetMapping
		public Iterable<Room> getRooms() {
			
			return this.roomRepository.findAll();
			
		}
	}
	
	@RestController
	@RequestMapping("/reservations")
	public class ReservationController {
		@Autowired
		private ReservationRepository ReservationRepository;
		
		@GetMapping
		public Iterable<Reservation> getRooms() {
			
			return this.ReservationRepository.findAll();
			
		}
	}
	*/

}
