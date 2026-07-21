/**
 * College Management System - CollegeManagementSystemDemo
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: A console UI implementing the CMS.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

private static final Scanner keyboard = new Scanner(System.in);
private static final CollegeManagementSystem cms = new CollegeManagementSystem(30, "pass123", "user123");

public static void main(String[] args) {
    int option;

    System.out.println("Welcome to the College Management System, Programming Project made by Chris B, Maryam A and Anh V\n");

    System.out.println("Would you like to pre-load a list of classes (1), or manually enter the details of each class as admin (2)?");

    option = keyboard.nextInt();
    if (option == 1) cms.preLoadClasses();

    do {
        System.out.println("Are you an admin (1), student (2), faculty member (3) or log off (any other number)?");
        option = keyboard.nextInt();

        if (option == 1) { // admin
            System.out.println("Enter username: ");
            keyboard.nextLine();
            String username = keyboard.nextLine();
            System.out.println("Enter password: ");
            String password = keyboard.nextLine();

            if (cms.validateAdmin(username, password)) {
                boolean loggedIn = true;
                while (loggedIn) {
                    System.out.println("""
                            \nEnter 1 to manage faculty members
                            Enter 2 to manage classes
                            Enter 3 to log off""");

                    option = keyboard.nextInt();

                    if (option == 1) {
                        cms.manageFaculty();
                    } else if (option == 2) {
                        cms.manageClasses();
                    } else if (option == 3) {
                        System.out.println("Logging off...");
                        loggedIn = false;
                    } else {
                        System.out.println("Invalid option");
                    }
                }
            } else {
                System.out.println("Invalid username or password");
            }

        } else if (option == 2) { // student
            System.out.println("Would you like to log on (1) or create an account (2)?");

            option = keyboard.nextInt();

            if (option == 1) {
                System.out.println("Enter your username: ");
                keyboard.nextLine();
                String username = keyboard.nextLine();
                System.out.println("Enter your password: ");
                String password = keyboard.nextLine();

                if (cms.validateStudent(username, password)) {
                    cms.manageYourClasses(cms.returnStudent(username, password));
                } else {
                    System.out.println("Invalid username or password");
                }
            } else if (option == 2) {
                System.out.println("Enter your full name: ");
                keyboard.nextLine();
                String fullName = keyboard.nextLine();
                System.out.println("Enter DOB; enter year, month and day of birth (all integers) separated by the enter or space key: ");
                int year = keyboard.nextInt();
                int month = keyboard.nextInt();
                int day = keyboard.nextInt();
                LocalDate birthDate = LocalDate.of(year, month, day);

                if (cms.searchStudents(fullName, birthDate)) {
                    System.out.println("Your account already exists");
                } else {
                    System.out.println("Enter your username of choice: ");
                    keyboard.nextLine();
                    String username = keyboard.nextLine();
                    System.out.println("Enter your password of choice: ");
                    String password = keyboard.nextLine();

                    int studentId = (int) (Math.random() * 1000);
                    Student student = new Student(fullName, studentId, birthDate, username, password);
                    cms.addUser(username, password, student);

                    cms.manageYourClasses(student);
                }

            }
        } else if (option == 3) { // faculty member
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("Would you like to log on (1) or create an account (2)?");
                option = keyboard.nextInt();
                if (option == 1) {
                    System.out.println("Enter your username: ");
                    keyboard.nextLine();
                    String username = keyboard.nextLine();
                    System.out.println("Enter your password: ");
                    String password = keyboard.nextLine();

                    if (cms.validateFaculty(username, password)) {
                        System.out.println("Would you like to reassign a part time faculty member to one of your classes (1), view your classes (2) or log off (3)?");
                        option = keyboard.nextInt();
                        if (option == 1) {
                            cms.reassignPTFaculty(cms.returnFaculty(username, password));
                        } else if (option == 2) {
                            cms.viewYourClassesToTeach(cms.returnFaculty(username, password));
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Invalid username or password");
                    }
                } else if (option == 2) {
                    System.out.println("Enter your full name: ");
                    keyboard.nextLine();
                    String fullName = keyboard.nextLine();
                    System.out.println("Enter your faculty ID: ");
                    int facultyID = keyboard.nextInt();

                    if (cms.getFaculty(fullName, facultyID).isUser()) {
                        System.out.println("Your account already exists");
                    } else {
                        System.out.println("Enter your username of choice: ");
                        keyboard.nextLine();
                        String username = keyboard.nextLine();
                        System.out.println("Enter your password of choice: ");
                        String password = keyboard.nextLine();

                        Faculty faculty = cms.getFaculty(fullName, facultyID);

                        cms.addUser(username, password, faculty);

                        faculty.setUser(username, password);
                        System.out.println("Account created");
                    }

                } else if (option == 3) {
                    loggedIn = false;
                } else {
                    System.out.println("Invalid option");
                }
            }
        }
    } while (option <= 3);
    {
    }

    System.out.println("Goodbye!");

}