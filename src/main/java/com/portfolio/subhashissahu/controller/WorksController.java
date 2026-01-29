package com.portfolio.subhashissahu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.portfolio.subhashissahu.model.Contact;
import com.portfolio.subhashissahu.model.Works;
import com.portfolio.subhashissahu.service.ContactService;
import com.portfolio.subhashissahu.service.WorksService;
@CrossOrigin(origins = "https://subhashis-sahu.vercel.app")
@RestController
public class WorksController {

    private final WorksService worksService;
    private final ContactService contactService;

    public WorksController(WorksService worksService ,ContactService contactService) {
        this.worksService = worksService;
        this.contactService=contactService;
    }

    @GetMapping("/public/works")
    public ResponseEntity<List<Works>> getAllWorks() {
        return worksService.getAllWorks();
    }

    @GetMapping("/public/works/{id}")
    public ResponseEntity<Works> getWorksById(@PathVariable int id) {
        return worksService.getWorksById(id);
    }

    // @PostMapping("/admin/works")
    // public ResponseEntity<String> addWorks(@RequestBody Works work) {
    //     return worksService.addWorks(work);
    // }

    // @DeleteMapping("/admin/works/{id}")
    // public ResponseEntity<String> deleteWorkById(@PathVariable int id) {
    //     return worksService.deleteWorkById(id);
    // }

    @GetMapping("/admin/check")
    public ResponseEntity<?> checkAuth() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/public/contact")
    public ResponseEntity<String> addContact(@RequestBody Contact contact )
    {
        System.out.println("Hit contact");
        return contactService.addContact(contact);


    }

    // @GetMapping("/admin/allContacts")
    // public ResponseEntity<List<Contact>> getAllContacts()
    // {
    //     return contactService.getAllContacts();

    // }
    // @GetMapping("/admin/contact/{id}")
    // public ResponseEntity<Contact> getContactsById(@PathVariable Long id)
    // {
    //     return contactService.getContactById(id);

    // }
}
