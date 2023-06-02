package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, Long> {
}
