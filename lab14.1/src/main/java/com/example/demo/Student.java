package com.example.demo;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setStudent(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    // конструктор, геттеры и сеттеры
}
