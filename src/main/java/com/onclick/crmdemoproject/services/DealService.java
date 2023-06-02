package com.onclick.crmdemoproject.services;


import com.onclick.crmdemoproject.models.Contact;
import com.onclick.crmdemoproject.models.Deal;
import com.onclick.crmdemoproject.repositories.ContactRepository;
import com.onclick.crmdemoproject.repositories.DealRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DealService {

    private final DealRepository dealRepository;
    private final ContactService contactService;

    public DealService(DealRepository dealRepository, ContactService contactService) {
        this.dealRepository = dealRepository;
        this.contactService = contactService;
    }

    public Optional<Deal> findById(Long id) {
        return dealRepository.findById(id);
    }

    @Transactional
    public Deal saveDeal(Deal deal, Long contactId) {
        Contact contact = contactService.getContactById(contactId);
        deal.setContact(contact);
        return dealRepository.save(deal);
    }

    @Transactional
    public void deleteDeal(Long id) {
        dealRepository.deleteById(id);
    }

    public Page<Deal> findAllByContactId(Long contactId, Pageable pageable) {
        return dealRepository.findAllByContactId(contactId, pageable);
    }
}
