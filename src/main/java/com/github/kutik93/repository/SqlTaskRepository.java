package com.github.kutik93.repository;

import com.github.kutik93.model.Task;
import com.github.kutik93.service.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Long> {

}
