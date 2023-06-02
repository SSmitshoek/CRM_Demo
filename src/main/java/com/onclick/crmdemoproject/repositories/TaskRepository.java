package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findAllByContactId(Long contactId, Pageable pageable);
}
