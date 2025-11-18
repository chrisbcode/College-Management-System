import java.lang.reflect.Method;

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
    String AdminPassword, AdminUsername;

    public CollegeManagementSystem() {
        super();
    }

    public CollegeManagementSystem(int sizeOfCollegeClassList, String AdminPassword, String AdminUsername) {
        ArrayBasedList<CollegeClass> CollegeClasses = new ArrayBasedList<>(sizeOfCollegeClassList);
        this.AdminPassword = AdminPassword;
        this.AdminUsername = AdminUsername;
    }

    public void manageClasses() {} // will ask the admin for options to modify, view details, and add or cancel classes

    public void manageFaculty() {} // will ask the admin for options to hire, fire, and view details of faculty members and their credits

    public boolean searchStudents(Student student) {
        return false;
    }

    public boolean searchFaculty(Faculty faculty) {
        return false;
    }

}
