package com.hyvercode.demo.service;

import com.hyvercode.demo.model.entity.Employee;
import com.hyvercode.demo.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    /**
     * @return
     */
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    /**
     * @param employee
     * @return
     */
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * @param employee
     * @return
     */
    public Employee update(long id, Employee employee) {

        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee Id " + id));

        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());

        return employeeRepository.save(emp);
    }

    /**
     * @param
     * @return
     */
    public Employee show(long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee Id " + id));
        return emp;
    }

    /**
     * @param id
     */
    public void delete(long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee Id " + id));

        employeeRepository.delete(emp);
    }
}
