package com.example.demo.web;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.domain.RoomReservation;
import com.example.demo.business.service.ReservationService;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebServiceController {
// rest web service para retornar jsons das reservas dos quartos dado uma data
	
	public RoomReservationWebServiceController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	private final ReservationService reservationService;
	
	@GetMapping
	public List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false)String dateString) {
		Date date = DateUtils.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
	}
	
	
}
