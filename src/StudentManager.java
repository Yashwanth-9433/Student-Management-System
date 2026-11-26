import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "students.txt";

    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();
    }

    public boolean isIdPresent(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) {
        if (isIdPresent(student.getId())) {
            System.out.println("Error: Student ID " + student.getId() + " already exists.");
            return;
        }
        students.add(student);
        if (saveStudents()) {
            System.out.println("Student added successfully.");
        } else {
            students.remove(student);
            System.out.println("Failed to save. Student was not added.");
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void updateStudent(String id, String newName, int newAge, String newCourse) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                String oldName = s.getName();
                int oldAge = s.getAge();
                String oldCourse = s.getCourse();

                try {
                    s.setName(newName);
                    s.setAge(newAge);
                    s.setCourse(newCourse);
                } catch (IllegalArgumentException e) {
                    s.setName(oldName);
                    s.setAge(oldAge);
                    s.setCourse(oldCourse);
                    System.out.println("Invalid input: " + e.getMessage());
                    return;
                }

                if (saveStudents()) {
                    System.out.println("Student updated successfully.");
                } else {
                    s.setName(oldName);
                    s.setAge(oldAge);
                    s.setCourse(oldCourse);
                    System.out.println("Failed to save. Update cancelled.");
                }
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                if (saveStudents()) {
                    System.out.println("Student deleted successfully.");
                } else {
                    students.add(s);
                    System.out.println("Failed to save. Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    private boolean saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    private void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                try {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String course = parts[3].trim();

                    if (isIdPresent(id)) {
                        System.out.println("Skipping duplicate ID: " + id);
                        continue;
                    }
                    students.add(new Student(id, name, age, course));
                } catch (Exception e) {
                    System.out.println("Skipping corrupted record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}