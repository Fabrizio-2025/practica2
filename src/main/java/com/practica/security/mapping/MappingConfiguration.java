package com.practica.security.mapping;

import com.practica.security.mapping.mappers.EmployeeMapper;
import com.practica.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EmployeeMapper employeeMapper(){
        return new EmployeeMapper();
    }
}
