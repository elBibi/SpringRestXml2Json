package org.example.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.model.Employee;

import static org.springframework.http.MediaType.*;

@RestController
public class SpringRestController {

    @GetMapping(value="/entityEmployees", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<List<Employee>> getEmployeesEntity()    {
        return new ResponseEntity<List<Employee>>(employees(), HttpStatus.OK);
    }

    @GetMapping(value="/employees",produces = {APPLICATION_JSON_VALUE,
    APPLICATION_XML_VALUE,
    TEXT_XML_VALUE})
    public List<Employee> getEmployees(){
        return employees();
    }

    @GetMapping(value="/employee",produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_XML_VALUE})
    public Employee getEmployee(){
        return new Employee("John","Developer");
    }

    private List<Employee> employees(){
        List<Employee> employees = Arrays.asList(new Employee("John","Developer"),
                new Employee("Michel","Sr Developer"),new Employee("Harris","developer"),
                new Employee("Kamala","Sr Developer"),new Employee("Jerome","Manager"));
        return employees;
    }


}
