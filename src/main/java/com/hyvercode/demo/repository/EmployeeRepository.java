package com.hyvercode.demo.repository;

import com.hyvercode.demo.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
