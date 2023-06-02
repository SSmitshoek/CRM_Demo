package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
