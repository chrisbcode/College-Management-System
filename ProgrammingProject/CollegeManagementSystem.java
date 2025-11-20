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
    String adminPassword, adminUsername;

    public CollegeManagementSystem() {
        super();
    }

    public CollegeManagementSystem(int sizeOfCollegeClassList, String adminPassword, String adminUsername) {
        ArrayBasedList<CollegeClass> CollegeClasses = new ArrayBasedList<>(sizeOfCollegeClassList);
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
    }

    public void manageClasses(String adminPassword) {
    }

    public void manageFaculty(String adminPassword) {} // will ask the admin for options to hire, fire, and view details of faculty members and their credits

    
    public void reassignFaculty(String adminPassword) {}

    public void reassignPTFaculty(Faculty faculty) {
        if(faculty.isFullTime()) {
            ;
        }
    }


    public boolean searchStudents(Student student) { // for admin
        return false;
    }

    public boolean searchStudents(String username, String password) {
        return false;
    }

    public boolean searchFaculty(Faculty faculty) { // for admin
        return false;
    }

    public boolean searchFaculty(String username, String password) {
        return false;
    }

}
