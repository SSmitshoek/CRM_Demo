package com.onclick.crmdemoproject.controllers;

import com.onclick.crmdemoproject.models.Deal;
import com.onclick.crmdemoproject.services.DealService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/deals")
public class DealController {
    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deal> getDealById(@PathVariable Long id) {
        Optional<Deal> deal = dealService.findById(id);
        return deal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{contactId}")
    public ResponseEntity<Deal> createDeal(@Valid @RequestBody Deal deal, @PathVariable Long contactId) {
        return new ResponseEntity<>(dealService.saveDeal(deal, contactId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeal(@PathVariable Long id) {
        dealService.deleteDeal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/contact/{contactId}")
    public ResponseEntity<Page<Deal>> getAllDealsByContactId(@PathVariable Long contactId, Pageable pageable) {
        return ResponseEntity.ok(dealService.findAllByContactId(contactId, pageable));
    }

}