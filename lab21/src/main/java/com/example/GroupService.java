// Интерфейс GroupService
package com.example;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GroupService {

    ResponseEntity<?> addGroup(String groupName);

    ResponseEntity<?> getGroupWithStudents(Long groupId);

    ResponseEntity<?> createGroup(Group group);

    List<Group> getAllGroups();

    Group getGroupById(Long groupId);

    ResponseEntity<?> deleteGroup(Long groupId);
}
