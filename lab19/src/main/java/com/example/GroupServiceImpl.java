package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public ResponseEntity<?> addGroup(String groupName) {
        log.info("Adding group with name: {}", groupName);
        Group group = new Group();
        group.setGroupName(groupName);
        groupRepository.save(group);
        log.info("Group {} created successfully!", groupName);
        return ResponseEntity.ok("Group " + groupName + " created successfully!");
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getGroupWithStudents(Long groupId) {
        log.info("Fetching group with id: {}", groupId);
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (!groupOptional.isPresent()) {
            log.warn("Group with id {} not found", groupId);
            return ResponseEntity.notFound().build();
        }

        Group group = groupOptional.get();
        group.getStudents().size(); // Это просто, чтобы инициализировать список студентов

        return ResponseEntity.ok(group);
    }

    @Override
    public ResponseEntity<?> createGroup(Group group) {
        log.info("Creating group: {}", group);
        groupRepository.save(group);
        log.info("Group {} created successfully!", group.getGroupName());
        return ResponseEntity.ok("Group " + group.getGroupName() + " created successfully!");
    }

    @Override
    public List<Group> getAllGroups() {
        log.info("Fetching all groups");
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long groupId) {
        log.info("Fetching group by id: {}", groupId);
        return groupRepository.findById(groupId).orElse(null);
    }

    @Override
    public ResponseEntity<?> deleteGroup(Long groupId) {
        log.info("Deleting group with id: {}", groupId);
        groupRepository.deleteById(groupId);
        return ResponseEntity.ok("Group with id " + groupId + " deleted successfully!");
    }
}
