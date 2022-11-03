package com.github.kutik93.controller;

import com.github.kutik93.model.Task;
import com.github.kutik93.service.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration")
public class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository repo;

    @Test
    void httpGet_returnGivenTask() throws Exception {
        //given
        Long id = repo.save(new Task("foo", LocalDateTime.now())).getId();
        //when + then
        mockMvc.perform(get("/tasks/" + id)).andExpect(status().is2xxSuccessful());
    }
}




