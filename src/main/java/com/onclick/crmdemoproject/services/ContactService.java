package com.onclick.crmdemoproject.services;

import com.onclick.crmdemoproject.exceptions.ResourceNotFoundException;
import com.onclick.crmdemoproject.models.Contact;
import com.onclick.crmdemoproject.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = getContactById(id);

        contact.setFirstName(contactDetails.getFirstName());
        contact.setLastName(contactDetails.getLastName());
        contact.setEmail(contactDetails.getEmail());
        contact.setPhone(contactDetails.getPhone());

        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        Contact contact = getContactById(id);
        contactRepository.delete(contact);
    }
}
