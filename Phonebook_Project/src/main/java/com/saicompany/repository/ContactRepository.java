package com.saicompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saicompany.binding.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	//select * from contacts where active_Sw = :status
	public   List<Contact> findByActiveSw(String status);
		
	

}
