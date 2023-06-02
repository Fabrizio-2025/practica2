package com.practica.security.domain.persistence;

import com.practica.security.domain.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();
    Optional<Employee> findByEmployeeId(Long employeeId);
    Boolean existsByEmployeeId(Long employeeId);
}
