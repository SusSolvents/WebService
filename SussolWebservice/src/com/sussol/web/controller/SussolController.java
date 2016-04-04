package com.sussol.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SussolController {

	@RequestMapping("/")
	public ModelAndView index() {
	   //returns the view name
	   return new ModelAndView("index");
	 }
}
