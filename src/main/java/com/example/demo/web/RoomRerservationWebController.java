package com.example.demo.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.business.domain.RoomReservation;
import com.example.demo.business.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class RoomRerservationWebController {

	private final ReservationService reservationService;
	
	@Autowired
	public RoomRerservationWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	
	@GetMapping // all gets in this URL will be responded to by this method
	public String getReservations(@RequestParam(value="date", required = false)String dateString, Model model) { // Model is to create web page
		Date date = DateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "reservations"; // this is going to tell thymeleaf to go find a template named reservations, use that template, 
		//pass this model that came into the method, but pass it to the reservations template and merge with the thymeleaf engine
	}
}
