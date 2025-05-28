package com.springboot.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//	@RequestMapping("home")
//	public String home(HttpServletRequest req) {
//		
//		String name = req.getParameter("name");
//		System.out.println("Home page " + name);
//		HttpSession session = req.getSession();
//		session.setAttribute("name", name);
//		return "home";
//	}

//	@RequestMapping("home")
//	// same name only works - need ReqeustParam
//	public ModelAndView home(@RequestParam("name") String myName) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("name", myName);
//		modelAndView.setViewName("home");
//		System.out.println("Home page " + myName);
//		return modelAndView;
//	}
	
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("alien", alien);
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
