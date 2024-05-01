package com.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public ResponseEntity<?> addStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("groupId") Long groupId) {
        return studentService.addStudent(firstName, lastName, groupId);
    }

    @GetMapping("/filterByName")
    public List<Student> filterStudentsByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return studentService.filterStudentsByName(firstName, lastName);
    }

    @GetMapping("/filterByGroup")
    public List<Student> filterStudentsByGroup(@RequestParam("groupId") Long groupId) {
        return studentService.filterStudentsByGroup(groupId);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
