package com.practica.shared.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
    private final String authorName;
    private final String authorGithubUrl;
    private final String projectTitle;
    private final String projectDescription;

    public Project(String authorName, String projectDescription, String authorGithubUrl, String projectTitle) {
        this.authorName = authorName;
        this.projectDescription = projectDescription;
        this.authorGithubUrl = authorGithubUrl;
        this.projectTitle = projectTitle;
    }
}
