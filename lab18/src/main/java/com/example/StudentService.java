package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public ResponseEntity<?> addStudent(String firstName, String lastName, Long groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            return ResponseEntity.badRequest().body("Group with id " + groupId + " not found.");
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGroup(group);

        studentRepository.save(student);

        return ResponseEntity.ok("Student " + firstName + " successfully created!");
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> filterStudentsByName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> filterStudentsByGroup(Long groupId) {
        return studentRepository.findByGroupId(groupId);
    }

    public ResponseEntity<?> deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return null;
    }
}
