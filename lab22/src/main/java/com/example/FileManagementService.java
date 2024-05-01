package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.File;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@ManagedResource(objectName = "com.example:type=FileManagementService")
public class FileManagementService {

    private final GroupService groupService;
    private final StudentService studentService;

    public FileManagementService(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    // Метод, вызываемый каждые 30 минут
    @Scheduled(cron = "0 */30 * * * *")
    @ManagedOperation(description = "Clear directory and manage files")
    public void manageFiles() {

        // Путь к директории для хранения файлов
        String directoryPath = "C:\\Users\\Asus\\IdeaProjects\\lab22\\src\\main\\java\\com\\example\\Files";

        // Очистка директории
        boolean success = clearDirectory(directoryPath);

        if (success) {
            System.out.println("Directory cleared successfully.");
        } else {
            System.out.println("Failed to clear directory.");
            return; // Прерываем выполнение метода, если не удалось очистить директорию
        }

        // Получение всех групп из базы данных
        List<Group> groups = groupService.getAllGroups();

        // Создание файлов для каждой сущности Group и заполнение их данными из базы данных
        for (Group group : groups) {
            String fileName = directoryPath + "/" + group.getGroupName() + ".txt";
            String fileContent = generateGroupFileContent(group);
            createFileWithData(fileName, fileContent);
        }

        // Получение всех студентов из базы данных
        List<Student> students = studentService.getAllStudents();

        // Создание файлов для каждой сущности Student и заполнение их данными из базы данных
        for (Student student : students) {
            String fileName = directoryPath + "/" + student.getLastName() + ".txt";
            createFileWithData(fileName, student.toString());
        }

        System.out.println("Scheduled task for file management executed.");
        // Дополнительный код для выполнения операций с файлами и базой данных
    }

    private boolean clearDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return false;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    boolean deleted = file.delete();
                    if (!deleted) {
                        System.out.println("Failed to delete file: " + file.getName());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void createFileWithData(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("File " + fileName + " created successfully.");
        } catch (IOException e) {
            System.out.println("Failed to create file " + fileName + ": " + e.getMessage());
        }
    }

    private String generateGroupFileContent(Group group)
    {
        StringBuilder content = new StringBuilder();
        content.append("Group Name: ").append(group.getGroupName()).append("\n");
        content.append("Students:\n");
        List<Student> students = studentService.getAllStudents();
        for (Student student : students)
        {
            content.append("- ").append(student.getLastName()).append("\n");
        }
        return content.toString();
    }

//    private void createFile(String fileName, String content) {
//        try {
//            FileWriter writer = new FileWriter(fileName);
//            writer.write(content);
//            writer.close();
//            System.out.println("File " + fileName + " created successfully.");
//        } catch (IOException e) {
//            System.out.println("Failed to create file " + fileName + ": " + e.getMessage());
//        }
//    }
}



