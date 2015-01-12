package org.example.mvc.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HelloController {

	@RequestMapping("/")
	public ModelAndView home(ModelMap model)
	{
		model.addAttribute("name", "Hello world");
		return new ModelAndView("index");
	}

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "User") String name) {
		ModelAndView mv = new ModelAndView("welcome_mvc");
		mv.addObject("name", name);
		mv.addObject("message", "Welcome to spring mvc using Jtwig and Jetty Application Server");
		return mv;
	}
}
