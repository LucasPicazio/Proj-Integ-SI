package com.pisi.marketplace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pisi.marketplace.business.service.MemberService;
import com.pisi.marketplace.data.entity.Member;

@Controller
@RequestMapping("/members")
public class MemberWebController {

	private final MemberService reservationService;
	
	@Autowired
	public MemberWebController(MemberService reservationService) {
		this.reservationService = reservationService;
	}
	
	
	@GetMapping // all gets in this URL will be responded to by this method
	public String getMembers(Model model) {
		List<Member> members = this.reservationService.getAllMembers();
		model.addAttribute("members", members);
		return "members"; // this is going to tell thymeleaf to go find a template named reservations, use that template, 
		//pass this model that came into the method, but pass it to the reservations template and merge with the thymeleaf engine
	}
}
