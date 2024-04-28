package com.example;
import org.springframework.http.HttpStatus;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private SessionFactory sessionFactory;

    @PostMapping
    public void createGroup(@RequestBody Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(group);
            tx.commit();
        }
    }

    @GetMapping
    public List<Group> getAllGroups() {
        try (Session session = sessionFactory.openSession()) {
            // Вместо session.createQuery используйте Criteria API для построения запроса с join fetch
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Group> cq = cb.createQuery(Group.class);
            Root<Group> root = cq.from(Group.class);
            root.fetch("students", JoinType.LEFT); // Загрузка студентов при получении групп

            // Выполнение запроса
            return session.createQuery(cq).getResultList();
        }
    }

    @GetMapping("/{groupId}/students")
    public ResponseEntity<?> getGroupWithStudents(@PathVariable Long groupId) {
        try (Session session = sessionFactory.openSession()) {
            Group group = session.get(Group.class, groupId);
            if (group == null) {
                return ResponseEntity.notFound().build();
            }

            // Загрузка студентов группы
            List<Student> students = group.getStudents();

            return ResponseEntity.ok(group);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving group with students.");
        }
    }



    @GetMapping("/add")
    public ResponseEntity<String> addGroup(@RequestParam("groupName") String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(group);
            tx.commit();
        }

        return ResponseEntity.ok("Group " + groupName + " created successfully!");
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Group group = session.get(Group.class, id);
            if (group != null) {
                session.delete(group);
            }
            tx.commit();
        }
    }
}
