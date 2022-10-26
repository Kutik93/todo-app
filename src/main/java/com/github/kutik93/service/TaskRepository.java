package com.github.kutik93.service;

import com.github.kutik93.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task entity);
    boolean existsById(Long id);
    boolean existsByGroupDoneIsFalseAndGroup_Id(Long groupId);
    List<Task> findByDone(boolean state);
    Page<Task> findAll(Pageable page);
    void deleteById(Long id);
    List<Task> findAllByGroup_Id(long id);
}
