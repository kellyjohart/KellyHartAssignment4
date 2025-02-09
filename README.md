# Student Enrollment System with File I/O 🎓📂

## Overview 🌟

This Java-based project is designed to manage and process student enrollment data. It reads student information from a CSV file, sorts it based on courses and grades, and outputs the sorted data into course-specific CSV files. The primary goal of this system is to demonstrate file handling, sorting algorithms, and object-oriented programming concepts.

## Features 🛠️

- **File Input/Output**: Reads student data from a master CSV file and writes sorted data to separate course-specific files. 📥📤
- **Student Sorting**: Sorts students by grade within each course. 🎯
- **Object-Oriented Design**: The project uses multiple Java classes to handle different responsibilities (file management, sorting, student objects). 🔄
- **CSV File Handling**: Outputs student data to CSV files organized by course. 🗂️

## Tech Stack ⚙️

- **Java 8+** – Used for implementation.
- **Java I/O (BufferedReader, BufferedWriter)** – For reading from and writing to files. 📖🖊️
- **Comparator** – For sorting student records based on grade and course. 🧮

## Project Structure 📂

src
 └── main
      └── java
           └── com
                └── coderscampus
                     └── assignment4
                          ├── FileService.java
                          ├── Student.java
                          ├── StudentEnrollmentApp.java
                          └── StudentService.java
 └── resources
      └── student-master-list.csv
