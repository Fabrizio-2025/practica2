package com.practica.security.mapping.mappers;

import com.practica.practica.resource.create.CreateEmployeeResource;
import com.practica.practica.resource.show.EmployeeResource;
import com.practica.practica.resource.update.UpdateEmployeeResource;
import com.practica.security.domain.model.entity.Employee;
import com.practica.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class EmployeeMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public EmployeeResource toResource(Employee usermodel) {
        return mapper.map(usermodel, EmployeeResource.class);
    }

    public List<EmployeeResource> toListResource(List<Employee> stores) {
        return mapper.mapList(stores, EmployeeResource.class);
    }

    public Employee createResourceToModel(CreateEmployeeResource createProductResource) {
        return mapper.map(createProductResource, Employee.class);
    }

    public Employee updateResourceToModel(UpdateEmployeeResource updateProductResource) {
        return mapper.map(updateProductResource, Employee.class);
    }
}
