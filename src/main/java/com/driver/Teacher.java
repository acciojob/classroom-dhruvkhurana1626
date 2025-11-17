package com.driver;

public class Teacher {
    private String name;
    private int numberOfStudents;
    private int age;

    public Teacher() {
    }

    public Teacher(int numberOfStudents, String name, int age) {
        this.numberOfStudents = numberOfStudents;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}