package com.portfolio.subhashissahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.subhashissahu.model.Contact;
import com.portfolio.subhashissahu.repo.ContactRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    @Autowired
    public ContactRepo contactRepo;

    public ResponseEntity<String> addContact(Contact contact) {
        Contact c=new Contact();
        c.setName(contact.getName());
        c.setEmail(contact.getEmail());
        c.setMessage(contact.getMessage());
        contactRepo.save(c);

        return ResponseEntity.ok("Added Succesfully");
    }

    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactRepo.findAll());
    }

    public ResponseEntity<Contact> getContactById(Long id) {
        Contact exitsContact=contactRepo.findById(id).orElseThrow( ()-> new EntityNotFoundException("Not found"));

        return ResponseEntity.ok(exitsContact);

    }
    
}
