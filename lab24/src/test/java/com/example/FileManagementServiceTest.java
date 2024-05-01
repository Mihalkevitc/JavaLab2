package com.example;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class FileManagementServiceTest {

    @Mock
    private GroupService groupService;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private FileManagementService fileManagementService;

    @Test
    public void testManageFiles() {
        // Arrange

        // Act
        fileManagementService.manageFiles();

        // Assert
        // Verify that the methods of groupService and studentService are called as expected
        verify(groupService).getAllGroups();
        verify(studentService).getAllStudents();
    }


}
