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
```

## Recent Updates (After GUVI Evaluator feedback for Redo)

- **Duplicate ID Prevention:** Added case-insensitive duplicate ID checks when adding new records and loading from `students.txt`.
- **Input & Field Validation:** Enforced validation in `Student` and `Main` to block empty inputs, commas in fields, invalid names (letters and spaces only), and out-of-range ages (5–100).
- **Safe File Handling:** Updated file read/write operations in `StudentManager` to use `try-with-resources` so streams close automatically.
- **Fault-Tolerant Loading:** Added per-line validation and error handling when reading `students.txt` to skip malformed or duplicate lines without interrupting startup.
- **Data Consistency:** Added rollback logic for add, update, and delete operations so in-memory `ArrayList` changes are reverted if saving to `students.txt` fails.
