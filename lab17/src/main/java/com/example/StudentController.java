package com.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{

    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping("/add")
    public ResponseEntity<?> addStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("groupId") Long groupId) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Group group = session.get(Group.class, groupId);
            if (group == null) {
                return ResponseEntity.badRequest().body("Group with id " + groupId + " not found.");
            }

            student.setGroup(group);
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating student.");
        }

        return ResponseEntity.ok("Student " + firstName + " successfully created!");
    }

    @GetMapping("/filterByName")
    public List<Student> filterStudentsByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> root = cq.from(Student.class);

            cq.where(
                    cb.and(
                            cb.equal(root.get("firstName"), firstName),
                            cb.equal(root.get("lastName"), lastName)
                    )
            );

            return session.createQuery(cq).getResultList();
        }
    }

    @GetMapping("/filterByGroup")
    public List<Student> filterStudentsByGroup(@RequestParam("groupId") Long groupId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> root = cq.from(Student.class);

            cq.where(cb.equal(root.get("group").get("id"), groupId));

            return session.createQuery(cq).getResultList();
        }
    }


    @GetMapping
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            tx.commit();
        }
    }
}
