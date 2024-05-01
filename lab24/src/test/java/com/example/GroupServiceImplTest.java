package com.example;

import com.example.Group;
import com.example.GroupRepository;
import com.example.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private GroupServiceImpl groupService;

    @Test
    void testAddGroup() {
        // Подготовка данных
        String groupName = "TestGroup";

        // Заглушка для метода save группы
        when(groupRepository.save(any())).thenReturn(new Group());

        // Вызов метода, который тестируем
        ResponseEntity<?> response = groupService.addGroup(groupName);

        // Проверка
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Group " + groupName + " created successfully and email send!", response.getBody());

    }


    @Test
    void testCreateGroup() {
        Group group = new Group();
        group.setGroupName("Test Group");

        ResponseEntity<?> responseEntity = groupService.createGroup(group);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Group " + group.getGroupName() + " created successfully!", responseEntity.getBody());
    }

    @Test
    void testGetAllGroups() {
        List<Group> groupList = List.of(new Group(), new Group());

        when(groupRepository.findAll()).thenReturn(groupList);

        List<Group> result = groupService.getAllGroups();

        assertEquals(groupList.size(), result.size());
    }



    @Test
    void testDeleteGroup() {
        Long groupId = 1L;

        ResponseEntity<?> responseEntity = groupService.deleteGroup(groupId);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Group with id " + groupId + " deleted successfully!", responseEntity.getBody());

        verify(groupRepository, times(1)).deleteById(groupId);
    }
}

