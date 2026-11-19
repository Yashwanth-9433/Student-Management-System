# Student Management System (CLI)

A console-based Java application for managing student records with persistent file storage.

## Features
- Option 1 - Add new student records
- Option 2 - View all stored students in a formatted table
- Option 3 - Update existing student details by ID
- Option 4 - Delete student records safely using `Iterator`
- Option 5 - Persistent data storage via plain-text file handling (`students.txt`)

## Concepts Used
- **Core Java & OOP:** Encapsulation, Constructors, Method Overriding (`toString`)
- **Collection Framework:** `List`, `ArrayList`, `Iterator`
- **File I/O & Exception Handling:** `BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`, `IOException`, `NumberFormatException`

## How to Run
```bash
javac src/*.java
java -cp src Main
