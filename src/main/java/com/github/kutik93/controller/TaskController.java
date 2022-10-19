package com.github.kutik93.controller;

import com.github.kutik93.repository.SqlTaskRepository;
import com.github.kutik93.model.Task;
import com.github.kutik93.service.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(SqlTaskRepository.class);
    private final TaskRepository repository;

    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/tasks", params = {"!sort", "!page", "!size"}, method = RequestMethod.GET)
    ResponseEntity<?> readAllTasks() {
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    ResponseEntity<Task> readTask(@PathVariable long id) {
        return repository.findById(id).map(task -> ResponseEntity.ok(task)).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody @Valid Task toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id).ifPresent(task -> task.updateFrom(toUpdate));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    ResponseEntity addTask(@RequestBody Task addTask) {
        repository.save(addTask);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteTask(@PathVariable long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @Transactional
    @PatchMapping(value = "/tasks/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id).ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }

}

