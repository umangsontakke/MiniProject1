package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.contact.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactInfoContorller {

	private ContactService service;

	public ContactInfoContorller(ContactService service) {
		this.service = service;
		// TODO Auto-generated constructor stub
	}

	/* this method display contact */
	@GetMapping("/load-form")
	public String loadForm(Model model) {
		Contact cobj = new Contact();
		// sending data from controller to UI
		model.addAttribute("contact", cobj);
		// Returing logical view name
		return "contact";

	}

	@PostMapping("/saveContact")
	public String HandleSubmitBtn(Contact contact,Model model) {
		boolean isSaved = service.saveOrContact(contact);
		if(isSaved)
		{
			model.addAttribute("successMsg","Contact saved");
		}
		else
		{
			model.addAttribute("successMsg","failed to save Contact");
		}
		return "contact";

	}

	@GetMapping("/view-contacts")
	public String HandleViewContactHyperLink(Model model) {
		List<Contact> allcontacts = service.getAllcontacts();
		model.addAttribute("contacts",allcontacts);
		
		return "contacts-display";
		
	}

	
	
}
