package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentProperties
{

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    public void printStudentInfo()
    {
        System.out.println("Name: " + name);
        System.out.println("Last Name: " + lastName);
        System.out.println("Group: " + group);
    }


}
