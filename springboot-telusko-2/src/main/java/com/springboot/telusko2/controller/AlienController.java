package com.springboot.telusko2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.telusko2.model.Alien;
import com.springboot.telusko2.repository.AlienRepository;

@Controller
//@RestController
public class AlienController {

	@Autowired
	AlienRepository alienRepository;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienRepository.save(alien);
		return "home.jsp";
	}
	

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView  modelAndView  = new ModelAndView("showalien.jsp");
		Alien alien = alienRepository.findById(aid).orElse(new Alien());
		modelAndView.addObject(alien);
		return modelAndView;
	}

	
	@RequestMapping("/getAliensByTech")
	public ModelAndView getAlienByTech(@RequestParam String tech) {
		ModelAndView  modelAndView  = new ModelAndView("showalien.jsp");
		List<Alien> Alienslist = alienRepository.findByTech(tech);
		System.out.println(Alienslist);
		modelAndView.addObject("lists", Alienslist);
		return modelAndView;
	}
	
	@RequestMapping("/getAliensGreaterThan")
	public ModelAndView getAlienGreaterThan(@RequestParam int aid) {
		ModelAndView  modelAndView  = new ModelAndView("showalien.jsp");
		List<Alien> Alienslist = alienRepository.findByAidGreaterThan(aid);
		System.out.println(Alienslist);
		modelAndView.addObject("lists", Alienslist);
		return modelAndView;
	}

	
	@RequestMapping("/getAliensTechSorted")
	public ModelAndView getAlienTechSorted(@RequestParam String tech) {
		ModelAndView  modelAndView  = new ModelAndView("showalien.jsp");
		List<Alien> Alienslist = alienRepository.findByTechSorted(tech);
		System.out.println(Alienslist);
		modelAndView.addObject("lists", Alienslist);
		return modelAndView;
	}
	
	// Rest 
	
	// Restrict only JSON/XML
	@RequestMapping(path= "/aliens", produces = {"application/xml"})
	@ResponseBody
	public List<Alien> getAllAliens() {
		return alienRepository.findAll();
	}
	
	
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable int aid) {
		return alienRepository.findById(aid);
	}
	
	
	@PostMapping(path="/rest/addAlien", consumes = {"application/json"})
	@ResponseBody
	public Alien restAddAlien(@RequestBody Alien alien) {
		return alienRepository.save(alien);
	}
	
	@DeleteMapping(path="/alien/{aid}")
	@ResponseBody
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = alienRepository.findById(aid).get();
		alienRepository.delete(alien);
		return "deleted";
	}
	
	@PutMapping("/alien")
	@ResponseBody
	public  Alien updateAlien(@RequestBody Alien alien) {
		return alienRepository.save(alien);
	}
}
