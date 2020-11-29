package com.pisi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/")
	public ModelAndView doc() {
		return new ModelAndView("redirect:/swagger-ui.html");
	}
}
