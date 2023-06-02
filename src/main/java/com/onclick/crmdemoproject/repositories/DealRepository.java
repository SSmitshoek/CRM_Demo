package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, Long> {
    Page<Deal> findAllByContactId(Long contactId, Pageable pageable);
}
