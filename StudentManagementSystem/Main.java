import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n======================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.println("======================================");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n----- Add Student -----");

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // Clear buffer

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();

                    students.add(new Student(id, name, age));

                    System.out.println("\n✓ Student Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n========== STUDENT RECORDS ==========");

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {

                        System.out.printf("%-10s %-25s %-10s%n",
                                "ID", "NAME", "AGE");

                        System.out.println("------------------------------------------------");

                        for (Student s : students) {
                            System.out.printf("%-10d %-25s %-10d%n",
                                    s.id, s.name, s.age);
                        }
                    }

                    System.out.println("=====================================");
                    break;

                case 3:
                    System.out.print("\nEnter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean found = students.removeIf(s -> s.id == deleteId);

                    if (found) {
                        System.out.println("✓ Student Deleted Successfully!");
                    } else {
                        System.out.println("✗ Student Not Found!");
                    }

                    break;

                case 4:
                    System.out.println("\nThank you for using Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option! Please try again.");
            }
        }
    }
}