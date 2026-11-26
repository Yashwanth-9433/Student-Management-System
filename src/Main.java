import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Student Management System ===");

        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine().trim();
                        if (id.isEmpty()) {
                            System.out.println("Error: Student ID cannot be empty.");
                            break;
                        }
                        if (manager.isIdPresent(id)) {
                            System.out.println("Error: Student ID " + id + " already exists.");
                            break;
                        }
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine().trim();

                        manager.addStudent(new Student(id, name, age, course));
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        String updateId = scanner.nextLine().trim();
                        if (updateId.isEmpty()) {
                            System.out.println("Error: Student ID cannot be empty.");
                            break;
                        }
                        if (!manager.isIdPresent(updateId)) {
                            System.out.println("Student ID " + updateId + " not found.");
                            break;
                        }
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine().trim();
                        System.out.print("Enter New Age: ");
                        int newAge = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter New Course: ");
                        String newCourse = scanner.nextLine().trim();

                        manager.updateStudent(updateId, newName, newAge, newCourse);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        String deleteId = scanner.nextLine().trim();
                        if (deleteId.isEmpty()) {
                            System.out.println("Error: Student ID cannot be empty.");
                            break;
                        }

                        manager.deleteStudent(deleteId);
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}