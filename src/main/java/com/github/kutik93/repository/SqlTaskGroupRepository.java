package com.github.kutik93.repository;

import com.github.kutik93.model.TaskGroup;
import com.github.kutik93.service.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Long> {

//    @Override
//    @Query("select distinct g from TaskGroup g join fetch g.tasks")
//    List<TaskGroup> findAll();
//
//    boolean existsByGroupDoneIsFalseAndGroup_Id(Long groupId);
}
