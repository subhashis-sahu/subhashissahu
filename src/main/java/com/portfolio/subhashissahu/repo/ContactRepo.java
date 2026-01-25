package com.portfolio.subhashissahu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.subhashissahu.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
    
}
