package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> addStudent(String firstName, String lastName, Long groupId) {
        log.info("Adding student with firstName: {}, lastName: {}, groupId: {}", firstName, lastName, groupId);

        Group group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            log.warn("Group with id {} not found", groupId);
            return ResponseEntity.badRequest().body("Group with id " + groupId + " not found.");
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGroup(group);

        studentRepository.save(student);

        log.info("Student {} {} successfully created!", firstName, lastName);
        return ResponseEntity.ok("Student " + firstName + " successfully created!");
    }

    @Override
    public void createStudent(Student student) {
        log.info("Creating student: {}", student);
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Fetching all students");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> filterStudentsByName(String firstName, String lastName) {
        log.info("Filtering students by name: {} {}", firstName, lastName);
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Student> filterStudentsByGroup(Long groupId) {
        log.info("Filtering students by groupId: {}", groupId);
        return studentRepository.findByGroupId(groupId);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long studentId) {
        log.info("Deleting student with id: {}", studentId);
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok("Student with id " + studentId + " deleted successfully!");
    }
}
