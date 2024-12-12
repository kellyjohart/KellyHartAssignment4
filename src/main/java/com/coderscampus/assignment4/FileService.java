package com.coderscampus.assignment4;

import java.io.*;
import java.time.chrono.MinguoDate;


public class FileService {


    public Student[] readStudentsFromFile(String fileName) {
        Student[] masterList = new Student[100];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] studentArray = line.split(",");
                Student student = new Student(studentArray[0], studentArray[1], studentArray[2], Integer.parseInt(studentArray[3]));
                masterList[counter++] = student;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file " + fileName + ": " + e.getMessage());
        }
        return masterList;
    }

    public void writeStudentsToFile(String fileName, Student[] students) {
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