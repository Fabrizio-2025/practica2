package com.practica.practica.resource.show;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private Double monthOfYear;

    private Double workedHours;

    private Double salaryByHours;

    private Double salaryofMonth;

    private Double tax;

    private Double netSalary;

    private LocalDateTime reportDateTime;

}
