package com.practica.security.service;

import com.practica.security.domain.model.entity.Employee;
import com.practica.security.domain.persistence.EmployeeRepository;
import com.practica.security.domain.service.EmployeeService;
import com.practica.shared.exception.ResourceNotFoundException;
import com.practica.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String entity = "Employee";
    private final EmployeeRepository userRepository;
    private final Validator validator;

    public EmployeeServiceImpl(EmployeeRepository userRepository,Validator validator){
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<Employee> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Employee getById(Long userId) {
        return userRepository.findByEmployeeId(userId).orElseThrow(() -> new ResourceNotFoundException(entity, userId));
    }

    @Override
    public Employee create(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);

        // Calculate
        Double taxPercentage = 0D;

        Double monthSalary = employee.getSalaryByHours() * employee.getWorkedHours();
        // Condition
        if (monthSalary < 1500) {
            taxPercentage = 0.08; //
        } else {
            taxPercentage = 0.1;//supondre que el impuesto es 10, porque en el PDF dice 8% en los 2 casos
        }
        Double netSalary = monthSalary * (1 - taxPercentage);

        // Setting new attributes from other attributes
        employee.setTax(monthSalary * taxPercentage);
        employee.setSalaryofMonth(monthSalary);
        employee.setNetSalary(netSalary);
        employee.setReportDateTime(LocalDateTime.now());
        return userRepository.save(employee);
    }

    public Employee update(Long userId, Employee updatedUser) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(updatedUser);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!userRepository.existsByEmployeeId(userId))
            throw new ResourceValidationException("User does not exist.");

        Employee existingUser = userRepository.findByEmployeeId(userId).get();



        return userRepository.save(existingUser
                .withFirstName(updatedUser.getFirstName())
                .withLastName(updatedUser.getLastName())
                .withMonthOfYear(updatedUser.getMonthOfYear())
                .withWorkedHours(updatedUser.getWorkedHours())
                .withSalaryByHours(updatedUser.getSalaryByHours())
        );
    }
    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findByEmployeeId(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, userId));
    }

}
