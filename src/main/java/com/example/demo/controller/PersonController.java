package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Person;
import com.example.demo.model.PersonWrapper;
import com.example.demo.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@RequestMapping("/get")
	@ResponseBody
	public Iterable<Person> getAll(){
		return ps.getAll();
	}
	
	@RequestMapping("/save")
	public String save(Model model) {
		model.addAttribute("person", new PersonWrapper());
		return "person";
	}
	@RequestMapping(value="/saveaction", method=RequestMethod.POST)
	@ResponseBody
	public String submitForm(Model model, PersonWrapper p) {
		Person p2 = ps.save(p.getFullname(), p.getLocId(), p.getAge());
		return "Person "+p2.getPersonPK().getFullname()+" saved";
	}

}
