package com.example;

import com.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddStudent() {
        // Arrange
        Group group = new Group();
        when(groupRepository.findById(1L)).thenReturn(Optional.of(group));

        String firstName = "John";
        String lastName = "Doe";

        // Act
        ResponseEntity<?> responseEntity = studentService.addStudent(firstName, lastName, 1L);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    void testCreateStudent() {
        // Arrange
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");

        // Act
        studentService.createStudent(student);

        // Assert
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<Student> result = studentService.getAllStudents();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testFilterStudentsByName() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        when(studentRepository.findByFirstNameAndLastName(firstName, lastName)).thenReturn(new ArrayList<>());

        // Act
        List<Student> result = studentService.filterStudentsByName(firstName, lastName);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testFilterStudentsByGroup() {
        // Arrange
        Long groupId = 1L;
        when(studentRepository.findByGroupId(groupId)).thenReturn(new ArrayList<>());

        // Act
        List<Student> result = studentService.filterStudentsByGroup(groupId);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        ResponseEntity<?> responseEntity = studentService.deleteStudent(studentId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        verify(studentRepository, times(1)).deleteById(studentId);
    }
}
