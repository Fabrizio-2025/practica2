package com.practica.security.api.rest;

import com.practica.practica.resource.create.CreateEmployeeResource;
import com.practica.practica.resource.show.EmployeeResource;
import com.practica.practica.resource.update.UpdateEmployeeResource;
import com.practica.security.domain.service.EmployeeService;
import com.practica.security.mapping.mappers.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="employees",produces = "application/json")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService,EmployeeMapper employeeMapper){
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;

    }
    @GetMapping("all")
    public List<EmployeeResource> getAllUser(){
        return employeeMapper.toListResource(employeeService.getAll());
    }

    @GetMapping("{id}")
    public EmployeeResource getById(@PathVariable long id){
        return employeeMapper.toResource(employeeService.getById(id));
    }

    @PostMapping
    public EmployeeResource createUser(@RequestBody CreateEmployeeResource userResource) {
        return employeeMapper.toResource(employeeService.create(employeeMapper.createResourceToModel(userResource)));
    }

    @PutMapping("{id}")
    public EmployeeResource updateUser(@PathVariable Long id, @RequestBody UpdateEmployeeResource userResource){
        return employeeMapper.toResource(employeeService.update(id,employeeMapper.updateResourceToModel(userResource)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return employeeService.delete(id);
    }




}
