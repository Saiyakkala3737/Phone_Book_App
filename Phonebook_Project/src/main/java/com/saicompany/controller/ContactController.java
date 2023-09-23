package com.saicompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.saicompany.binding.Contact;
import com.saicompany.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "This is Contact API")
public class ContactController {

	@Autowired
	ContactService service;

	@ApiOperation("This operation is used to store new contact")
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		return service.saveContact(contact);
	}

	@ApiOperation("This operation is used to get all contact")
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		List<Contact> contacts=service.getAllContacts();
		return contacts;
	}

	@ApiOperation("This operation is used to retreive  contact by contact id")
	@GetMapping("/contact/{ContactId}")
	public Contact getContactId(@PathVariable Integer ContactId) {
		return service.getContactById(ContactId);
	}

	@ApiOperation("This operation is used to update contact")
	@PutMapping("/update")
	public String UpdateContact(@RequestBody Contact contact) {
		String update=service.updateContact(contact);
		return update;
	}

	@ApiOperation("This operation is used to delete contact")
	@DeleteMapping("/contact/{contactId}")
	public String DeleteContactByID(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}



}
