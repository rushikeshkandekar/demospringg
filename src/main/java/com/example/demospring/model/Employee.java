package com.example.demospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;


    public Employee() {

    }
}

