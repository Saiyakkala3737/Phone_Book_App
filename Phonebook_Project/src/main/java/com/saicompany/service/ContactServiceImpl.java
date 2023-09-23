package com.saicompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saicompany.binding.Contact;
import com.saicompany.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {

		contact.setActiveSw("Y");
		contact = repo.save(contact);
		if(contact.getId()!=null) {
			return "contact saved";
		}else {
			return "contact not saved";
		}
	}

	@Override
	public List<Contact> getAllContacts() {

		//return repo.findAll();
		return repo.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById= repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if(repo.existsById(contact.getId())){
			repo.save(contact);
			return "Update success";
		}else {
			return "No record found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		/*if(repo.existsById(contactId)){
			repo.deleteById(contactId);
			return "Contact Deleted";
		}else {
			return "Contact not deleted";
		}*/

		Optional<Contact> findById=repo.findById(contactId);
		if(findById.isPresent()) {
			Contact contact=findById.get();
			contact.setActiveSw("N");;
			repo.save(contact);
			return "Record deleted";
		}else {
			return "No record found";
		}
	}


}

