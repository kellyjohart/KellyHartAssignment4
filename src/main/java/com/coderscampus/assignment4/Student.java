package com.coderscampus.assignment4;



public class Student {
    private String id;
    private String name;
    private String course;
    private int grade;

    public Student(String id, String name, String course, int grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }
}
