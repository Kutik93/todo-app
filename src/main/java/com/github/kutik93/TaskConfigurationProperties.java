package com.github.kutik93;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task")
public class TaskConfigurationProperties {

    private boolean allowMultipletTasksFromTemplate;

    public boolean isAllowMultipletTasksFromTemplate() {
        return allowMultipletTasksFromTemplate;
    }

    public void setAllowMultipletTasksFromTemplate(boolean allowMultipletTasksFromTemplate) {
        this.allowMultipletTasksFromTemplate = allowMultipletTasksFromTemplate;
    }
}
