package com.github.kutik93.repository;

import com.github.kutik93.model.Task;
import com.github.kutik93.service.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Long> {

    @Override
    @Query(nativeQuery = true, value = "select count(*) >0 from tasks where id=:id")
    boolean existsById(@Param("id") Long id);
}
