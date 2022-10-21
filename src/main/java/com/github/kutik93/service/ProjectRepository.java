package com.github.kutik93.service;

import com.github.kutik93.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> findAll();
    Optional<Project> findById(Long id);
    Project save(Project entity);
}
