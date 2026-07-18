/**
 * College Management System - CollegeManagementSystem
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: Combines implementations of Stack, List, Queue, and other classes to simulate a system that manages college classes and their attributes, interacting with admin, faculty and student.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class CollegeManagementSystem {
    private NodeBasedStack<Faculty> FacultyStack = new NodeBasedStack<>();
    private ArrayBasedList<CollegeClass> CollegeClasses;

    private ArrayBasedList<Faculty> FacultyList = new ArrayBasedList<>(100);
    private NodeBasedList<Student> StudentList = new NodeBasedList<>();

    private NodeBasedList<Faculty> PartTimeFacultyList = new NodeBasedList<>();

    private NodeBasedList<User> UserList = new NodeBasedList<>();

    private String adminPassword, adminUsername;

    public CollegeManagementSystem() {
        super();
    }

    public CollegeManagementSystem(int sizeOfCollegeClassList, String adminPassword, String adminUsername) {
        CollegeClasses = new ArrayBasedList<>(sizeOfCollegeClassList);
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
    }


    // system
    public boolean validateAdmin(String adminUsername, String adminPassword) {
        return adminUsername.equals(this.adminUsername) && adminPassword.equals(this.adminPassword);
    }

    public boolean validateFaculty(String facultyUsername, String facultyPassword) {
        return UserList.find(new User(facultyUsername, facultyPassword));
    }

    public boolean validateStudent(String studentUsername, String studentPassword) {
        return UserList.find(new User(studentUsername, studentPassword));
    }

    public boolean searchStudents(String fullName, LocalDate birthDate) {
        return StudentList.find(new Student(fullName, birthDate));
    }

    public boolean searchFaculty(String fullName, int facultyID) {
        return FacultyList.find(new Faculty(fullName, facultyID));
    }

    public Student returnStudent(String username, String password) {
        return UserList.find2(new User(username, password)).getStudent();
    }

    public Faculty returnFaculty(String username, String password) {
        return UserList.find2(new User(username, password)).getFaculty();
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
        keyboard.nextLine();
        if (option == 1) {
            System.out.println("Enter course name: ");
            String courseName = keyboard.nextLine();

            System.out.println("Enter course abbreviation: ");
            String courseAbbreviation = keyboard.nextLine();

            System.out.println("Enter course ID: ");
            int courseID = keyboard.nextInt();

            System.out.println("Enter class' section number: ");
            int courseSectionNumber = keyboard.nextInt();
            
            System.out.println("Enter class' day of the week: ");
            keyboard.nextLine();
            String courseDayOfWeek = keyboard.nextLine();

            System.out.println("Enter class' hour and minute seperated by spaces: ");
            int courseHour = keyboard.nextInt();
            int courseMinute = keyboard.nextInt();

            System.out.println("Enter the size of the class");
            int classSize = keyboard.nextInt();

            System.out.println("Enter the size of the class waitlist: ");
            int waitlistSize = keyboard.nextInt();
            
            System.out.println("Enter course credits: ");
            int courseCredits = keyboard.nextInt();

            CollegeClasses.add(new CollegeClass(courseName, courseAbbreviation, courseID, courseSectionNumber, courseDayOfWeek, courseHour, courseMinute, classSize, waitlistSize, courseCredits));
            System.out.println("Course added successfully!");
        } else if (option == 2) {
            System.out.println(CollegeClasses.toString2());
            System.out.println("Enter class to remove: ");
            option = keyboard.nextInt();
            CollegeClasses.remove(CollegeClasses.get(option));
        } else if (option == 3) {
            System.out.println(CollegeClasses);
        } else if (option == 4) {
            for (int i = 0; i < CollegeClasses.size(); i++) {
                System.out.println(CollegeClasses.get(i).toString2());
            }
        }

    }

    public void manageFaculty() {
        Scanner keyboard = new Scanner(System.in);
        int option;

        System.out.println("""
                \nEnter 1 to hire a faculty member
                Enter 2 to let go of a faculty member
                Enter 3 assign a member of the faculty to a class
                Enter 4 to view faculty members""");
        option = keyboard.nextInt();

        if (option == 1) {
            System.out.println("Enter faculty member's full name: ");
            keyboard.nextLine();
            String facultyName = keyboard.nextLine();
            System.out.println("Enter faculty member's employee ID: ");
            int employeeID = keyboard.nextInt();
            System.out.println("Enter faculty member's department: ");
            keyboard.nextLine();
            String department = keyboard.nextLine();

            System.out.println("Will faculty member be full time? (Y/N): ");
            String answer = keyboard.nextLine();
            boolean fullTime = answer.equalsIgnoreCase("Y");

            Faculty faculty = new Faculty(facultyName, employeeID, department, fullTime);

            if (fullTime) {
                PartTimeFacultyList.add(faculty);
            }

            FacultyList.add(faculty);
            FacultyStack.push(faculty);
        } else if (option == 2) {
            try {
                FacultyStack.pop();
                System.out.println("Faculty member of least seniority let go!");
            } catch (StackEmptyException e) {
                System.out.println(e.getMessage());
            }
        } else if (option == 3) {
            System.out.println(FacultyList.toString2());
            System.out.println("Choose faculty member to assign to class");
            option = keyboard.nextInt();

            System.out.println("Choose class to assign this faculty member to");

            CollegeClasses.get(keyboard.nextInt()).setProfessor(FacultyList.get(option));
        } else {
            System.out.println("Invalid option");
        }

    }

    //faculty
    public void reassignPTFaculty(Faculty faculty) {
        Scanner keyboard = new Scanner(System.in);
        int option;

        CollegeClass course = faculty.getCourse();

        System.out.println("Here is the list of part time faculty members:\n" + PartTimeFacultyList);
        System.out.println("Enter faculty member's full name: ");
        String facultyName = keyboard.nextLine();
        System.out.println("Enter faculty member's employee ID: ");
        int employeeID = keyboard.nextInt();

        course.setProfessor(PartTimeFacultyList.find2(new Faculty(facultyName, employeeID)));
    }

    public void viewYourClassesToTeach(Faculty faculty) {
        faculty.getClasses();
    }

    public Faculty getFaculty(String fullName, int employeeID) {
        return FacultyList.find2(new Faculty(fullName, employeeID));
    }

    //student
    public void manageYourClasses(Student student) {

        Scanner keyboard = new Scanner(System.in);
        int option;

        if (this.StudentList == null) {
            StudentList.add(student);
            System.out.print("You successfully entered this college! Your assigned student ID is " + student.getStudentId());
        } else if (!StudentList.find(student)) {
            StudentList.add(student);
            System.out.print("You successfully entered this college! Your assigned student ID is " + student.getStudentId());
        }

        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("""
                    \nEnter 1 to add a course to your class list
                    Enter 2 to remove a course from your class list
                    Enter 3 to view your class list
                    Enter 4 to log off""");
            option = keyboard.nextInt();

            if (option == 1) {
                System.out.println(CollegeClasses.toString2());
                System.out.println("Which college class would you like to add to your class list?");
                option = keyboard.nextInt();

                CollegeClasses.get(option - 1).addStudent(student); // automatically checks for availability and adds class to student's classes if joined successfully
            } else if (option == 2) {
                student.removeClass();
            } else if (option == 3) {
                student.getClasses();
            } else if (option == 4) {
                loggedIn = false;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }


}
