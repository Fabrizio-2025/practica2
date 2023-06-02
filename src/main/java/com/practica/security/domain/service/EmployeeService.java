package com.practica.security.domain.service;

import com.practica.security.domain.model.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(Long employeeId);

    Employee create(Employee saveEmployee);

    ResponseEntity<?> delete(Long id);

    Employee update(Long id, Employee updatedEmployee);
}
