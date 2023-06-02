package com.onclick.crmdemoproject.controllers;

import com.onclick.crmdemoproject.models.Task;
import com.onclick.crmdemoproject.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getNoteById(@PathVariable Long id) {
        Task deal = taskService.getTaskById(id);
        return ResponseEntity.ok(deal);
    }

    @GetMapping("/contact/{contactId}")
    public ResponseEntity<Page<Task>> getAllTasksByContactId(@PathVariable Long contactId, Pageable pageable) {
        return ResponseEntity.ok(taskService.findAllByContactId(contactId, pageable));
    }

    @PostMapping("/{contactId}")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task, @PathVariable Long contactId) {
        return new ResponseEntity<>(taskService.saveTask(task, contactId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        Task updatedNote = taskService.updateTaskById(id, taskDetails);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
