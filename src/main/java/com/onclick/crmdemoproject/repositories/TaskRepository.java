package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Note, Long> {
}
