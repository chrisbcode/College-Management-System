import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - CollegeManagementSystem Class
 */

public class CollegeManagementSystem {
    NodeBasedStack<Faculty> FacultyStack = new NodeBasedStack<>();
    ArrayBasedList<CollegeClass> CollegeClasses;

    NodeBasedList<Faculty> FacultyList;
    NodeBasedList<Student> StudentList;

    String adminPassword, adminUsername;

    public CollegeManagementSystem() {
        super();
    }

    public CollegeManagementSystem(int sizeOfCollegeClassList, String adminPassword, String adminUsername) {
        ArrayBasedList<CollegeClass> CollegeClasses = new ArrayBasedList<>(sizeOfCollegeClassList);
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
    }


    // system
    public boolean validateAdmin(String adminUsername, String adminPassword) {
        return adminUsername.equals(adminUsername) && adminPassword.equals(adminPassword);
    }

    public boolean validateFaculty(String facultyUsername, String facultyPassword) {
        return false;
    }

    public boolean validateStudent(String studentUsername, String studentPassword) {
        return false;
    }

    public boolean searchStudents(String fullName, LocalDate birthDate) { // for admin
        return false;
    }

    public boolean searchFaculty(String fullName, String password) {
        return false;
    }

    public Student returnStudent(String username, String password) {
        return null;
    }

    public Faculty returnFaculty(String username, String password) {
        return null;
    }


    //admin
    public void manageClasses() {

        Scanner keyboard = new Scanner(System.in);
        int option;

        System.out.println("""
                    \nEnter 1 to add a course
                    Enter 2 to remove a course
                    Enter 3 to view the course list
                    Enter 4 to view the course details""");
        option = keyboard.nextInt();

    }

    public void manageFaculty() {
        Scanner keyboard = new Scanner(System.in);
        int option;

        System.out.println("""
                    \nEnter 1 to hire a faculty member
                    Enter 2 to let go of a faculty member
                    Enter 3 assign a member of the faculty to a class
                    Enter 4 to reassign a member of the faculty to a class""");
        option = keyboard.nextInt();

    }

    //faculty
    public void reassignPTFaculty() {
        Scanner keyboard = new Scanner(System.in);
        int option;

        option = keyboard.nextInt();
    }

    public void viewYourClassesToTeach(Faculty faculty) {
        faculty.getCollegeClasses();
    }

    //student

    public void manageYourClasses(Student student) {

        Scanner keyboard = new Scanner(System.in);
        int option;

        if(!StudentList.find(student)) {
            StudentList.add(student);
            System.out.print("You successfully applied and entered this college! Your assigned student ID is " + student.getStudentId());
        }

        boolean loggedIn = true;
        while(loggedIn) {
            System.out.println("""
                    \nEnter 1 to add a course to your class list
                    Enter 2 to remove a course from your class list
                    Enter 3 to view your class list
                    Enter 4 to log off""");
            option = keyboard.nextInt();

            if(option == 1) {
                System.out.println(CollegeClasses);
                System.out.println("Which college class would you like to add to your class list?");
                option = keyboard.nextInt();


            }
            else if(option == 2) {
                ;
            }
            else if(option == 3) {
                ;
            }
            else if(option == 4) {
                loggedIn = false;
            }
            else {
                System.out.println("Invalid option!");
            }
        }
    }



}
