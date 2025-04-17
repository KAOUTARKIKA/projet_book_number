package com.example.book_number.ws;

import com.example.book_number.beans.Contact;
import com.example.book_number.dao.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/contact")
public class ContactRest {

    @Autowired
    private IDAO contactDao;

    // 🔹 GET all contacts
    @GetMapping("/")
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    // 🔹 GET contact by name
    @GetMapping("/name/{name}")
    public Contact findByName(@PathVariable String name) {
        return contactDao.findByName(name);
    }

    // 🔹 POST new contact
    @PostMapping("/")
    public Contact save(@RequestBody Contact contact) {
        return contactDao.save(contact);
    }

    // 🔹 POST batch of contacts
    @PostMapping("/batch")
    public void saveContactsBatch(@RequestBody List<Contact> contacts) {
        for (Contact contact : contacts) {
            // Vérifier si le contact existe déjà par nom
            Contact existingContact = contactDao.findByName(contact.getName());
            if (existingContact == null) {
                contactDao.save(contact);
            }
        }
    }

    // 🔹 DELETE contact by id
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        contactDao.deleteById(id);
    }

}