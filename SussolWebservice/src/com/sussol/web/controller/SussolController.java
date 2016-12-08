package com.sussol.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SussolController {

	@RequestMapping("/")
	public ModelAndView index() {
	   //returns the view name
	   return new ModelAndView("index");
	 }
	
	@RequestMapping(value = "/matrix", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
	    try {
	      String url = SussolController.class.getResource("resources/matrix.csv").getPath();
	      response.setContentType("text/csv");
	      response.addHeader("Content-Disposition", "attachment;filename=matrix9solvents.csv");
	      InputStream is = new FileInputStream(url.replaceAll("%20", " "));
	      
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	      ex.printStackTrace();
	      throw new RuntimeException("IOError writing file to output stream");
	    }
	}
}
