package com.practica.practica.resource.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResource {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private Long monthOfYear;

    private Long workedHours;

    private Long salaryByHours;
}
