package com.example;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "YourApp:name=FileManagementMBean", description = "File Management MBean")
public class FileManagementMBean {

    private final FileManagementService fileManagementService;

    public FileManagementMBean(FileManagementService fileManagementService) {
        this.fileManagementService = fileManagementService;
    }

    @ManagedOperation(description = "Execute file management task")
    public void executeFileManagementTask() {
        fileManagementService.manageFiles();
    }
}

