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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

//    @GetMapping("/filter")
//    public ResponseEntity<?> filterGroupsByName(@RequestParam("groupName") String groupName) {
//        return groupService.filterGroupsByName(groupName);
//    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{groupId}/students")
    public ResponseEntity<?> getGroupWithStudents(@PathVariable Long groupId) {
        return groupService.getGroupWithStudents(groupId);
    }

    @GetMapping("/add")
    public ResponseEntity<?> addGroup(@RequestParam("groupName") String groupName) {
        return groupService.addGroup(groupName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }
}

