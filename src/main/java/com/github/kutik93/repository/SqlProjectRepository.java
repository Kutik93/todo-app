package com.github.kutik93.repository;

import com.github.kutik93.model.Project;
import com.github.kutik93.service.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {
    @Override
    @Query("from Project p join fetch p.steps")
    List<Project> findAll();
}
