package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.contact.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactOperationsController {

	private ContactService service;

	public ContactOperationsController(ContactService service) {

		this.service = service;
	}

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contactObj = service.getContactById(contactId);

		model.addAttribute("contact", contactObj);
		return "contact";

	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId,Model model) {
		boolean isDeleted=service.deleteContatById(contactId);
		if(isDeleted) {
			model.addAttribute("succMsg","Contact Deleted Successfully");
		}
		else
		{
			model.addAttribute("failMsg","contact not deleted");
		}
		
		return "redirect:view-contacts";
		
		
	}

}
