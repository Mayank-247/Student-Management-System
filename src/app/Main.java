package app;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {

            System.out.println("\n------------------------------------");
            System.out.println("      Student Management System");
            System.out.println("------------------------------------");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Total Students");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    dao.addStudent();
                    break;

                case 2:

                    List<Student> students = dao.viewStudents();

                    if(students.isEmpty()) {
                        System.out.println("No students found.");
                    }
                    else {

                        System.out.printf("%-5s %-15s %-15s %-5s %-5s\n",
                                "ID","Name","Branch","Age","CGPA");

                        System.out.println("------------------------------------------------------");

                        for(Student s : students) {

                            System.out.printf("%-5d %-15s %-15s %-5d %-5.2f\n",
                                    s.getId(),
                                    s.getName(),
                                    s.getBranch(),
                                    s.getAge(),
                                    s.getCgpa());
                        }
                    }

                    break;

                case 3:
                    dao.searchStudent();
                    break;

                case 4:
                    dao.viewStudents();
                    dao.updateStudent();
                    break;

                case 5:
                    dao.viewStudents();
                    dao.deleteStudent();
                    break;

                case 6:
                    dao.totalStudents();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice");

            }

        }

    }
}