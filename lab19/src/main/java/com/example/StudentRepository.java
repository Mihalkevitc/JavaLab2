package com.example;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByGroupId(Long groupId);
}