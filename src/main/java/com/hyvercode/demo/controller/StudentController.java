package com.hyvercode.demo.controller;

import com.hyvercode.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private  List<Student> students = new ArrayList<>();

    /**
     * Get Object
     * @return
     */
    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Hyver","Code");
    }

    /**
     * Return List
     * @return
     */
    @GetMapping("/students")
    public List<Student> getStudents(){
        students.add(new Student("Hyver","code"));
        students.add(new Student("Moh","Irwan"));
        return students;
    };

    /**
     * Get By Name
     * @param firstName
     * @return
     */
    @GetMapping("/student/gc/{firstName}")
    public List<Student> getStudentByNameGC(@PathVariable("firstName") String firstName){
        return students
                .stream()
                .filter(s->s.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    /**
     * Get By Name
     * @param firstName
     * @return
     */
    @GetMapping("/student/{firstName}")
    public List<Student> getStudentByName(@PathVariable("firstName") String firstName){
        if(students.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student Not Found");
        }
        return students
                .stream()
                .filter(s->s.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }
}
