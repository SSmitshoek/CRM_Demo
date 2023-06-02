package com.onclick.crmdemoproject.controllers;

import com.onclick.crmdemoproject.models.Note;
import com.onclick.crmdemoproject.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note deal = noteService.getNoteById(id);
        return ResponseEntity.ok(deal);
    }

    @GetMapping("/contact/{contactId}")
    public ResponseEntity<Page<Note>> getAllNotesByContactId(@PathVariable Long contactId, Pageable pageable) {
        return ResponseEntity.ok(noteService.findAllByContactId(contactId, pageable));
    }

    @PostMapping("/{contactId}")
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note, @PathVariable Long contactId) {
        return new ResponseEntity<>(noteService.saveNote(note, contactId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note noteDetails) {
        Note updatedNote = noteService.updateNoteById(id, noteDetails);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

}
