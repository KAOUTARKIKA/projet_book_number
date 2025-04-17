package com.example.book_number.dao;

import com.example.book_number.beans.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDAO extends JpaRepository<Contact, Long> {
    Contact findByName(String name);
}