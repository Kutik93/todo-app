package com.github.kutik93;

import com.github.kutik93.model.Task;
import com.github.kutik93.service.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.*;

public class TestConfiguration {
    @Bean
    @Primary
    @Profile("!integration")
    DataSource e2eTestDataSource() {
        var result = new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        result.setDriverClassName("org.h2.Driver");
        return result;
    }

    @Bean
    @Primary
    @Profile("integration")
    TaskRepository testRepo() {
        return new TaskRepository() {
            Map<Long, Task> tasks = new HashMap<>();

            @Override
            public List<Task> findAll() {
                return new ArrayList<>(tasks.values());
            }

            @Override
            public Optional<Task> findById(Long id) {
                return Optional.ofNullable(tasks.get(id));
            }

            @Override
            public Task save(Task entity) {
                long key = tasks.size() + 1;
                tasks.put(key, entity);
                return tasks.get(key);
            }

            @Override
            public boolean existsById(Long id){
                return tasks.containsKey(id);
            }

            @Override
            public boolean existsByGroupDoneIsFalseAndGroup_Id(Long groupId) {
                return false;
            }


            @Override
            public Page<Task> findAll(Pageable page) {
                return null;
            }

            @Override
            public void deleteById(Long id) {

            }

        };
    }
}
