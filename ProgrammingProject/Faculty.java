import java.time.LocalDate;
import java.util.Scanner;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Faculty Class
 * Updated: 11.18.25 - 12:11am - not finish
 * 
 * Example that i make change to the code, then hit Ctrl + S or you can..., then go to Git Desktop
 */

public class Faculty extends Employee
{
    //instance variable
    private String department;
    private String username;
    private String password;
    private boolean fullTime;
    private ArrayBasedList<CollegeClass> collegeClasses = new ArrayBasedList<>(10);

    private static final int MAX_SECTIONS = 20;

    //constructors
    public Faculty() {
        super();
        this.department = "";
    }

    public Faculty(String newName, int facultyID, String department, boolean fullTime) {
        super(newName, facultyID);
        this.department = department;
        this.fullTime = fullTime;
    }

    public Faculty(String newName, int employeeID, String username, String password, String department) {
        super(newName, employeeID);
        this.department = department;
        this.username = username;
        this.password = password;
    }

    public Faculty(String fullName, int facultyID) {
        super(fullName, facultyID);
    }

    //setter & getters
    public void setDepartment(String facultyDepartment) {
        department = facultyDepartment;
    }

    public String getDepartment() {
        return department;
    }

    public int getCourses() { //return number of faculty was assigned
        return 0;
    }

    public int getCredits() {
        return 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addClass(CollegeClass collegeClass) {
        collegeClasses.add(collegeClass);
    }

    public void getClasses() {
        System.out.println(collegeClasses);
    }

    public CollegeClass getCourse() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(collegeClasses.toString2());
        System.out.println("Which class would you like to choose");
        int option = keyboard.nextInt();
        return collegeClasses.get(option - 1);
    }

    public void removeClass(CollegeClass collegeClass) {
        collegeClasses.remove(collegeClass);
    }

    @Override
    public String toString() {
        return super.toString() + " | Dept: " + department;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Faculty otherFaculty) {
            if(this.getName().equals(otherFaculty.getName()) && this.getEmployeeId() == otherFaculty.getEmployeeId()) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}