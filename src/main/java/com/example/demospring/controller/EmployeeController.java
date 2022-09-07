package com.example.demospring.controller;

import com.example.demospring.entity.EmployeeEntity;
import com.example.demospring.model.Employee;
import com.example.demospring.model.EmployeeResponde;
import com.example.demospring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
     /* for allEmployeee */
    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> emp = employeeService.getAllEmployees();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long employeeId) {
        EmployeeEntity employeeEntity = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponde> createEmployee(@RequestBody Employee employee) {
        EmployeeResponde emprs = employeeService.creatEmployee(employee);
        return new ResponseEntity<>(emprs, HttpStatus.OK);
    }

    @PutMapping(path = "employees/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Employee eupdate = employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(eupdate, HttpStatus.OK);
    }
    @DeleteMapping(path = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
