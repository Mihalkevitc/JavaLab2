// Интерфейс StudentService
package com.example;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<?> addStudent(String firstName, String lastName, Long groupId);

    void createStudent(Student student);

    List<Student> getAllStudents();

    List<Student> filterStudentsByName(String firstName, String lastName);

    List<Student> filterStudentsByGroup(Long groupId);

    ResponseEntity<?> deleteStudent(Long studentId);
}
