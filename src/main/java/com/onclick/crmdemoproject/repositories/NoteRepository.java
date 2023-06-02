package com.onclick.crmdemoproject.repositories;

import com.onclick.crmdemoproject.models.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findAllByContactId(Long contactId, Pageable pageable);
}
