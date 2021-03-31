package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.contact.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository repository;

	public ContactServiceImpl(ContactRepository repository) {

		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	@Override
	public boolean saveOrContact(Contact contact) {
		Contact savedobj = repository.save(contact);

		return savedobj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllcontacts() {
		// TODO Auto-generated method stub

		return repository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<Contact> findById = repository.findById(contactId);
		if (findById.isPresent()) {

			// Contact contact = findById.get();
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContatById(Integer contactId) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		try {
			repository.deleteById(contactId);
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDeleted;
	}

}
