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
    private int sectionCount;
    private String username;
    private String password;
    private int facultyID;

    private static final int MAX_SECTIONS = 20;

    //constructors
    public Faculty() {
        super();
        this.department = "";
        this.sectionCount = 0;
    }

    public Faculty(String newName, String birthDate, int employeeID, String username, String password, String department) {
        super(newName, birthDate, employeeID);
        this.department = department;
        this.sectionCount = 0;
        this.username = username;
        this.password = password;
    }

    /**
     * 6 unique constructors
     */

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


    @Override
    public String toString() {
        return super.toString()
                + ", Dept: " + department
                + ", Sections: " + sectionCount;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Faculty) { //if  there is an object and it is a person
            Faculty otherFaculty = (Faculty)otherObject; //object type casting,new ref of type person
            if(this.getName().equals(otherFaculty.getName()) && this.getEmployeeId() == otherFaculty.getEmployeeId() && this.department.equals(otherFaculty.getDepartment()) && super.equals(otherObject) && this.department.equals(otherFaculty.department)) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}