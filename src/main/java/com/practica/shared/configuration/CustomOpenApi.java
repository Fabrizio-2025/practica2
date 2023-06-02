package com.practica.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;

public class CustomOpenApi extends OpenAPI {
    private final Project project;
    public CustomOpenApi(Project project){
        super();
        this.project = project;
    }
}
