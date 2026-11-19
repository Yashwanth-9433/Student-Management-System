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
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();

                        manager.addStudent(new Student(id, name, age, course));
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New Course: ");
                        String newCourse = scanner.nextLine();

                        manager.updateStudent(updateId, newName, newAge, newCourse);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        String deleteId = scanner.nextLine();

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
            }
        }

        scanner.close();
    }
}