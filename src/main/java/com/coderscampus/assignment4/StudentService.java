package com.coderscampus.assignment4;

public class StudentService {
    public Student[] sortStudentsByCourse(Student[] masterList, String course) {
        if (masterList == null) {
            System.out.println("masterList is null");
            return new Student[0];
        }

        int counter = 0;
        for (Student student : masterList) {
            if (student != null && student.getCourse().startsWith(course)) {
                counter++;
            }
        }

        Student[] students = new Student[counter];
        int index = 0;
        for (Student student : masterList) {
            if (student != null && student.getCourse().startsWith(course)) {
                students[index++] = student;
            } else if (student == null) {
                System.out.println("Null student found in masterList");
            }
        }
        System.out.println("finished processing course: " + course);
        return students;
    }
}