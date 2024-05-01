package com.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final EmailService emailService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository, EmailService emailService) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public ResponseEntity<?> addStudent(String firstName, String lastName, Long groupId) {
        logger.info("Adding student with firstName: {}, lastName: {}, groupId: {}", firstName, lastName, groupId);

        Group group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            logger.warn("Group with id {} not found", groupId);
            return ResponseEntity.badRequest().body("Group with id " + groupId + " not found.");
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGroup(group);

        studentRepository.save(student);

        logger.info("Student {} {} successfully created!", firstName, lastName);
        emailService.sendEmail("Mihalkevitc.23V@yandex.ru", "Успешное создание студента", "Был создан студент "+ firstName + " " + lastName);
        logger.info("Email about {} {} successfully send!", firstName, lastName);
        return ResponseEntity.ok("Student " + firstName + " successfully created and email send!");
    }

    @Override
    public void createStudent(Student student) {
        logger.info("Creating student: {}", student);
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> filterStudentsByName(String firstName, String lastName) {
        logger.info("Filtering students by name: {} {}", firstName, lastName);
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Student> filterStudentsByGroup(Long groupId) {
        logger.info("Filtering students by groupId: {}", groupId);
        return studentRepository.findByGroupId(groupId);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long studentId) {
        logger.info("Deleting student with id: {}", studentId);
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok("Student with id " + studentId + " deleted successfully!");
    }
}
