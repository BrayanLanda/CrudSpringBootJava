package com.example.crudsena.controller;

import com.example.crudsena.entity.Student;
import com.example.crudsena.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student>getAll(){
        return studentService.getStudents();
    }
    @GetMapping("/{student_id}")
    public Optional<Student> getByID(@PathVariable("student_id") Long studentId){
        return studentService.getStudent(studentId);
    }
    @PostMapping
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{student_id}")
    public void dalete(@PathVariable("student_id") Long studentId){
        studentService.delete(studentId);
    }

}
