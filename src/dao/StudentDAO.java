package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import db.DBConnection;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO {

    public void addStudent() {

        try {

            Connection conn = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            if(age <= 0) {
                System.out.println("Invalid age! Age must be positive.");
                return;
            }

            System.out.print("Enter CGPA: ");
            float cgpa = sc.nextFloat();

            if(cgpa < 0 || cgpa > 10) {
                System.out.println("Invalid CGPA! Must be between 0 and 10.");
                return;
            }

            String query = "INSERT INTO students(name,branch,age,cgpa) VALUES(?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, branch);
            pst.setInt(3, age);
            pst.setFloat(4, cgpa);

            pst.executeUpdate();

            System.out.println("Student Added Successfully!");

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> viewStudents() {

        List<Student> students = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                s.setAge(rs.getInt("age"));
                s.setCgpa(rs.getFloat("cgpa"));

                students.add(s);
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }


    public void searchStudent() {

        try {

            Connection conn = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to search: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM students WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {

                System.out.println("\nStudent Found:\n");

                System.out.printf("%-5s %-15s %-15s %-5s %-5s\n", "ID", "Name", "Branch", "Age", "CGPA");
                System.out.println("------------------------------------------------------");

                System.out.printf(
                        "%-5d %-15s %-15s %-5d %-5.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getInt("age"),
                        rs.getFloat("cgpa")
                );

            } else {
                System.out.println("Student not found!");
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateStudent() {

        try {

            Connection conn = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();

            System.out.println("What do you want to update?");
            System.out.println("1 Name");
            System.out.println("2 Branch");
            System.out.println("3 Age");
            System.out.println("4 CGPA");

            int choice = sc.nextInt();
            sc.nextLine();

            PreparedStatement pst = null;

            if(choice == 1) {

                System.out.print("Enter new Name: ");
                String name = sc.nextLine();

                pst = conn.prepareStatement("UPDATE students SET name=? WHERE id=?");
                pst.setString(1, name);
                pst.setInt(2, id);

            }

            else if(choice == 2) {

                System.out.print("Enter new Branch: ");
                String branch = sc.nextLine();

                pst = conn.prepareStatement("UPDATE students SET branch=? WHERE id=?");
                pst.setString(1, branch);
                pst.setInt(2, id);

            }

            else if(choice == 3) {

                System.out.print("Enter new Age: ");
                int age = sc.nextInt();

                if(age <= 0) {
                    System.out.println("Invalid age!");
                    return;
                }

                pst = conn.prepareStatement("UPDATE students SET age=? WHERE id=?");
                pst.setInt(1, age);
                pst.setInt(2, id);

            }

            else if(choice == 4) {

                System.out.print("Enter new CGPA: ");
                float cgpa = sc.nextFloat();

                if(cgpa < 0 || cgpa > 10) {
                    System.out.println("Invalid CGPA!");
                    return;
                }

                pst = conn.prepareStatement("UPDATE students SET cgpa=? WHERE id=?");
                pst.setFloat(1, cgpa);
                pst.setInt(2, id);

            }

            if(pst != null) {
                pst.executeUpdate();
                System.out.println("Student Updated Successfully!");
                pst.close();
            } else {
                System.out.println("Invalid choice!");
            }

            conn.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteStudent() {

        try {

            Connection conn = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            System.out.print("Are you sure you want to delete? (y/n): ");
            String confirm = sc.next();

            if(!confirm.equalsIgnoreCase("y")) {
                System.out.println("Deletion cancelled.");
                return;
            }

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student not found!");
            }

            pst.close();
            conn.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void totalStudents() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT COUNT(*) AS total FROM students";

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                System.out.println("Total Students in Database: " + rs.getInt("total"));
            }

            rs.close();
            pst.close();
            conn.close();

        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }
}