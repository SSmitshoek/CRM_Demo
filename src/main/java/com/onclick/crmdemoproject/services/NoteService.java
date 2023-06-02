package com.onclick.crmdemoproject.services;

import com.onclick.crmdemoproject.exceptions.ResourceNotFoundException;
import com.onclick.crmdemoproject.models.Contact;
import com.onclick.crmdemoproject.models.Note;
import com.onclick.crmdemoproject.repositories.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ContactService contactService;

    public NoteService(NoteRepository noteRepository, ContactService contactService) {
        this.noteRepository = noteRepository;
        this.contactService = contactService;
    }

    @Transactional
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    @Transactional
    public Note saveNote (Note note, Long contactId) {
        Contact contact = contactService.getContactById(contactId);
        note.setContact(contact);
        return noteRepository.save(note);
    }

    @Transactional
    public void deleteNote (Long id) {
        Note note = getNoteById(id);
        noteRepository.delete(note);
    }

    @Transactional
    public Page<Note> findAllByContactId(Long contactId, Pageable pageable) {
        return noteRepository.findAllByContactId(contactId, pageable);
    }

    @Transactional
    public Note updateNoteById(Long id, Note noteDetails) {
        Note note = getNoteById(id);
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }
}
