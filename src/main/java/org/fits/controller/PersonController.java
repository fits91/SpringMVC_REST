package org.fits.controller;

import org.fits.beans.Person;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PersonController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value = "/bean/{id}", method = RequestMethod.GET)
	public Person getBean(@PathVariable int id) {
		Person Person = new Person();

		// get person here
		Person.id    =  id;
		Person.fName = "Anton"; // example val
		Person.sName = "Fedorets"; // example val
		Person.age   = 24; // example val

		System.out.println("return Person with id = " + id);

		return Person;
	}

	@RequestMapping(value = "/bean/{id}", method = RequestMethod.DELETE)
	public Person saveBean(@PathVariable int id) {
		Person person = new Person();
		person.id    =  id;

		// delete method here

		System.out.println("Person with id + " + id + " was deleted");
		return person;
	}

	@RequestMapping(value = "/bean/{id}", method = RequestMethod.PUT)
		public Person updateBean(@PathVariable int id) {
		Person person = new Person();
		person.id    =  id;

		// update bean here

		System.out.println("Person with id + " + id + " was updated");
		return person;
	}

	@RequestMapping(value = "/bean", method = RequestMethod.POST)
	public void createBean(@RequestBody Person person) {
		// create bean

		System.out.println("Person " + person + " was created");
	}
}