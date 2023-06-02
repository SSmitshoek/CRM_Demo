package com.onclick.crmdemoproject.services;

import com.onclick.crmdemoproject.exceptions.ResourceNotFoundException;
import com.onclick.crmdemoproject.models.Contact;
import com.onclick.crmdemoproject.models.Note;
import com.onclick.crmdemoproject.models.Task;
import com.onclick.crmdemoproject.repositories.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {
    private final ContactService contactService;
    private final TaskRepository taskRepository;

    public TaskService(ContactService contactService, TaskRepository taskRepository) {
        this.contactService = contactService;
        this.taskRepository = taskRepository;
    }
    @Transactional
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
    }

    @Transactional
    public Task saveTask (Task note, Long contactId) {
        Contact contact = contactService.getContactById(contactId);
        note.setContact(contact);
        return taskRepository.save(note);
    }

    @Transactional
    public void deleteTask (Long id) {
        Task note = getTaskById(id);
        taskRepository.delete(note);
    }

    @Transactional
    public Page<Task> findAllByContactId(Long contactId, Pageable pageable) {
        return taskRepository.findAllByContactId(contactId, pageable);
    }

    @Transactional
    public Task updateTaskById(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());
        return taskRepository.save(task);
    }
}
