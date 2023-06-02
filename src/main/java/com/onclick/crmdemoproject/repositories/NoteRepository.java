package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Task, Long> {
}
