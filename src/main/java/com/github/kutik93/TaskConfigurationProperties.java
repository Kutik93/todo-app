package com.github.kutik93;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    private TaskTemplate taskTemplate;

    public TaskTemplate getTemplate() {
        return taskTemplate;
    }

    public void setTemplate(TaskTemplate taskTemplate) {
        this.taskTemplate = taskTemplate;
    }
}
