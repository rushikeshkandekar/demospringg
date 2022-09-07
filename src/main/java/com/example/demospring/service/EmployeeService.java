package com.example.demospring.service;

import com.example.demospring.entity.EmployeeEntity;
import com.example.demospring.model.Employee;
import com.example.demospring.model.EmployeeResponde;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EmployeeService {
    private List<EmployeeEntity> employeeEntities;

    public EmployeeService() {
        employeeEntities = List.of(
                new EmployeeEntity(1L, "rushikesh", "kandekar"),
                new EmployeeEntity(2L, "rakesh", "karpe"),
                new EmployeeEntity(3L, "ajit", "aher"),
                new EmployeeEntity(4L, "akash", "karpe"));
    }


    public EmployeeEntity getEmployee(Long employeeId) {
        EmployeeEntity employeeEntity = null;
        for (EmployeeEntity ex : employeeEntities) {
            if (ex.getEmployeeId() == employeeId) {
                employeeEntity = ex;
                break;
            }
        }
        return employeeEntity;

       // return employeeEntities.stream().filter(t -> t.getEmployeeId() == employeeId).findFirst().get();
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        EmployeeEntity employeeEntity = null;
        for (EmployeeEntity e : employeeEntities) {
            if (employeeId == e.getEmployeeId()) {
                e.setFirstName(employee.getFirstName());
                e.setLastName(employee.getLastName());
                break;
            }
        }
        return employee;
    }


    public EmployeeResponde creatEmployee(Employee employee) {
        int employeeId = (int) (Math.random() * 20);
        EmployeeResponde emp = new EmployeeResponde();
        emp.setEmployeeId((long) employeeId);
        log.info("employee Name is {} {}", employee.getFirstName(), employee.getLastName());
        return emp;
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeEntities;
    }
    public void deleteEmployee(Long employeeId){
        //employeeEntities.stream().filter(t->t.getEmployeeId()!=employeeId).collect(Collectors.toList());
        log.info("deleted");
    }
}





