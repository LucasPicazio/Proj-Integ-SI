package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.business.service.ReservationService;
import com.example.demo.data.entity.Guest;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

	private final ReservationService reservationService;
	
	@Autowired
	public GuestWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	
	@GetMapping // all gets in this URL will be responded to by this method
	public String getGuests(Model model) {
		List<Guest> guests = this.reservationService.getAllGuests();
		model.addAttribute("guests", guests);
		return "guests"; // this is going to tell thymeleaf to go find a template named reservations, use that template, 
		//pass this model that came into the method, but pass it to the reservations template and merge with the thymeleaf engine
	}
}
