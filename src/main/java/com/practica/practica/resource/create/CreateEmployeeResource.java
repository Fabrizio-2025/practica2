package com.practica.practica.resource.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeResource {
    @JsonIgnore
    private Long employeeId;

    private String firstName;

    private String lastName;

    private Long monthOfYear;

    private Long workedHours;

    private Long salaryByHours;
}
