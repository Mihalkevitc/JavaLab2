package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public ResponseEntity<?> addGroup(String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);
        groupRepository.save(group);
        return ResponseEntity.ok("Group " + groupName + " created successfully!");
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> getGroupWithStudents(Long groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (!groupOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Group group = groupOptional.get();
        group.getStudents().size(); // Это просто, чтобы инициализировать список студентов

        return ResponseEntity.ok(group);
    }

    public ResponseEntity<?> createGroup(Group group) {
        groupRepository.save(group);
        return ResponseEntity.ok("Group " + group.getGroupName() + " created successfully!");
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public ResponseEntity<?> deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
        return ResponseEntity.ok("Group with id " + groupId + " deleted successfully!");
    }
}
