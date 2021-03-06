package com.hyvercode.demo.controller;

import com.hyvercode.demo.helpers.ResponseCode;
import com.hyvercode.demo.helpers.ResponseHandler;
import com.hyvercode.demo.model.entity.Employee;
import com.hyvercode.demo.model.request.EmployeeRequest;
import com.hyvercode.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getList() {
        return ResponseHandler.baseResponse(
                HttpStatus.OK,
                employeeService.all(),
                ResponseCode.HTTP_CODE_200.getCode(),
                ResponseCode.HTTP_CODE_200.getMessage());
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .build();
        return ResponseHandler.baseResponse(
                HttpStatus.CREATED,
                employeeService.create(employee),
                ResponseCode.HTTP_CODE_200.getCode(),
                ResponseCode.HTTP_CODE_200.getMessage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") long id) {
        return ResponseHandler.baseResponse(
                HttpStatus.OK,
                employeeService.show(id),
                ResponseCode.HTTP_CODE_200.getCode(),
                ResponseCode.HTTP_CODE_200.getMessage());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable("id") long id, @RequestBody EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .id(id)
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .build();
        return ResponseHandler.baseResponse(
                HttpStatus.CREATED,
                employeeService.update(id, employee),
                ResponseCode.HTTP_CODE_200.getCode(),
                ResponseCode.HTTP_CODE_200.getMessage());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        employeeService.delete(id);
        return ResponseHandler.baseResponse(
                HttpStatus.CREATED,
                new Object(),
                ResponseCode.HTTP_CODE_200.getCode(),
                ResponseCode.HTTP_CODE_200.getMessage());
    }

}
