package com.coderscampus.assignment4;
import java.util.Arrays;
import java.util.Comparator;

public class StudentEnrollmentApp {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        StudentService studentService = new StudentService();
        int numberOfCourses = 3;

        Student[] masterList = fileService.readStudentsFromFile("src/main/resources/student-master-list.csv");
        Comparator<Student> gradeComparator = Comparator.comparing(Student::getGrade, Comparator.nullsLast(Comparator.reverseOrder()));
        Arrays.sort(masterList, gradeComparator);


        String[] courses = new String[numberOfCourses];
        courses[0] = "COMPSCI";
        courses[1] = "APMTH";
        courses[2] = "STAT";

        for (String course : courses) {
            Student[] students = studentService.sortStudentsByCourse(masterList, course);
            fileService.writeStudentsToFile("src/main/resources/" + course + "-list.csv", students);
        }

    }
}