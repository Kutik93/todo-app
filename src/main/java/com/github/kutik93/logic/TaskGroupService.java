package com.github.kutik93.logic;

import com.github.kutik93.model.TaskGroup;
import com.github.kutik93.model.projection.GroupReadModel;
import com.github.kutik93.model.projection.GroupWriteModel;
import com.github.kutik93.service.TaskGroupRepository;
import com.github.kutik93.service.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;

    public TaskGroupService(TaskGroupRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(long groupId) {
        if (taskRepository.existsByGroupDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalArgumentException("Group has indone tasks. Done all the tasks first");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found"));
        result.setDone(!result.isDone());
        repository.save(result);
    }
}
