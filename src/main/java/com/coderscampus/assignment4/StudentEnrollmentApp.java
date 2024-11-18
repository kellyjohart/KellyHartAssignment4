package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentEnrollmentApp {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readStudentsFromFile("src/main/resources/student-master-list.csv");

        Comparator<Student> gradeComparator = (student1, student2) -> {
            if (student2 == null) {
                return -1;
            }
            if (student1 == null) {
                return 1;
            }

            return Integer.compare(student2.getGrade(), student1.getGrade()); //lambda expression
        };






        Arrays.sort(fileService.getCourse1(), gradeComparator);
        Arrays.sort(fileService.getCourse2(), gradeComparator);
        Arrays.sort(fileService.getCourse3(), gradeComparator);

        writeCourseFile("src/main/resources/course1.csv", fileService.getCourse1());
        writeCourseFile("src/main/resources/course2.csv", fileService.getCourse2());
        writeCourseFile("src/main/resources/course3.csv", fileService.getCourse3());

    }

    private static void writeCourseFile(String fileName, Student[] students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Student ID,Student Name,Course,Grade\n"); // Header
            for (Student student : students) {
                if (student == null) {
                    continue;
                }
                bw.write(student.getId() + "," + student.getName() + "," + student.getCourse() + "," + student.getGrade() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }
}