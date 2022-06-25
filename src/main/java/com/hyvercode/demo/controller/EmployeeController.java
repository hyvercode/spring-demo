package com.hyvercode.demo.controller;

import com.hyvercode.demo.model.entity.Employee;
import com.hyvercode.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getList(){
        return  employeeService.all();
    }

    @PostMapping("")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.show(id), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        employeeService.delete(id);

        return new ResponseEntity<>("Record has been deleted", HttpStatus.OK);
    }

}
