package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileService {

    private Student[] course1 = new Student[100];
    private Student[] course2 = new Student[100];
    private Student[] course3 = new Student[100];

    public void readStudentsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();
            int Counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] studentArray = line.split(",");
                Student student = new Student(studentArray[0], studentArray[1], studentArray[2], Integer.parseInt(studentArray[3]));
                String course = student.getCourse();
                if (course.startsWith("COMPSCI")) {
                    course1[Counter] = student;
                } else if (course.startsWith("APMTH")) {
                    course2[Counter] = student;
                } else if (course.startsWith("STAT")) {
                    course3[Counter] = student;
                }
                Counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeStudentsToFile(String fileName, Student[] students) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getCourse() + "," + student.getGrade() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Student[] getCourse1() {
        return course1;
    }

    public Student[] getCourse2() {
        return course2;
    }

    public Student[] getCourse3() {
        return course3;
    }

}