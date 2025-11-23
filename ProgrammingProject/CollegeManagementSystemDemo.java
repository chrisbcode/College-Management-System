import java.time.LocalDate;
import java.util.Scanner;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - CollegeManagementSystemDemo
 */

public class CollegeManagementSystemDemo {
    public static void main(String[] args){
        int option;
        Scanner keyboard = new Scanner(System.in);
        CollegeManagementSystem collegeManagementSystem = new CollegeManagementSystem(30, "password123", "user123");

        System.out.print("Welcome to the College Management System, Programming Project made by Chris B, Maryam A and Anh V\n");



        do {
            System.out.println("Are you an admin (1), student (2) or faculty member (3)?");
            option = keyboard.nextInt();

            if(option == 1){
                System.out.print("Enter username: ");
                String username = keyboard.nextLine();
                System.out.print("Enter password: ");
                String password = keyboard.nextLine();

                if(collegeManagementSystem.validateAdmin(username, password)){
                    boolean loggedIn = true;
                    while(loggedIn){
                        System.out.println("""
                        \nEnter 1 to manage faculty members
                        Enter 2 to manage classes
                        Enter 3 to log off""");

                        option = keyboard.nextInt();

                        if (option == 1) {
                            collegeManagementSystem.manageFaculty();
                        } else if (option == 2) {
                            collegeManagementSystem.manageClasses();
                        } else if (option == 3) {
                            System.out.println("Logging off...");
                            loggedIn = false;
                        }
                        else {
                            System.out.println("Invalid option");
                        }
                    }
                }

            }
            else if(option == 2){
                System.out.print("Would you like to log on (1) or create an account (2)?");
                option = keyboard.nextInt();
                if(option == 1){
                    System.out.print("Enter username: ");
                    String username = keyboard.nextLine();
                    System.out.print("Enter password: ");
                    String password = keyboard.nextLine();

                    if(collegeManagementSystem.validateStudent(username, password)){
                        collegeManagementSystem.manageYourClasses(collegeManagementSystem.returnStudent(username, password));
                    }
                    else {
                        System.out.println("Invalid username or password");
                    }
                }
                else if(option == 2){
                    System.out.print("Enter your full name: ");
                    String fullName = keyboard.nextLine();
                    System.out.print("Enter your date of birth, enter your year, month and day of birth seperated by the enter key: ");
                    int year = keyboard.nextInt();
                    int month = keyboard.nextInt();
                    int day = keyboard.nextInt();
                    LocalDate birthDate = LocalDate.of(year, month, day);

                    if(collegeManagementSystem.searchStudents(fullName, birthDate)) {
                        System.out.println("Your account already exists");
                    }
                    else {
                        System.out.println("Enter your username: ");
                        String username = keyboard.nextLine();
                        System.out.print("Enter your password: ");
                        String password = keyboard.nextLine();

                        int studentId = (int) (Math.random() * 1000);
                        Student student = new Student(fullName, studentId, birthDate, username, password);

                        collegeManagementSystem.manageYourClasses(student);
                    }

                }
            }
            else if(option == 3){
                System.out.println("""
                    \nEnter 1 to 
                    Enter 2 to
                    Enter 3 to
                    Enter 4 to
                    Enter 5 to  """);

                option = keyboard.nextInt();

                if (option == 1) {

                } else if (option == 2) {

                } else if (option == 3) {

                } else if (option == 4) {

                } else if (option == 5) {

                }
                else {

                }
            }
        }
        while(option != 5); {
        }


    }
}