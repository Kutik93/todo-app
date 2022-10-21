package com.github.kutik93.service;

import com.github.kutik93.model.Task;
import com.github.kutik93.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {

    List<TaskGroup> findAll();

    Optional<TaskGroup> findById(Long id);

    boolean existsByDoneIsFalseAndProject_Id(Long id);

    TaskGroup save(TaskGroup entity);

}
