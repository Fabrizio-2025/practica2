package com.practica.security.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "Employees")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long employeeId;

private String firstName;

private String lastName;


private Long monthOfYear;


private Double workedHours;


private Double salaryByHours;

private Double salaryofMonth;

private Double tax;

private Double netSalary;

private LocalDateTime reportDateTime;
}
