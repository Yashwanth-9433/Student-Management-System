import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "students.txt";

    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
        System.out.println("Student added successfully.");
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
            if (s.getId().equals(id)) {
                s.setName(newName);
                s.setAge(newAge);
                s.setCourse(newCourse);
                saveStudents();
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equals(id)) {
                iterator.remove();
                saveStudents();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    private void saveStudents() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    students.add(new Student(id, name, age, course));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
