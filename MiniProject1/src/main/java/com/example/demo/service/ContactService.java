package com.example.demo.service;

import java.util.List;

import com.example.demo.contact.Contact;

public interface ContactService {

	public boolean saveOrContact(Contact contact);
	
	public List<Contact> getAllcontacts();
	
	public Contact getContactById(Integer contactId);
	
	public boolean deleteContatById(Integer contactId);
	
}
