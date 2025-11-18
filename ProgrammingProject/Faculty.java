/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Faculty Class
 * Updated: 11.18.25 - 12:11am - not finish
 */

public class Faculty extends Employee
{
    //instance variable
    private String department;
    private CourseSection[] assignedSections;
    private int sectionCount;

    private static final int MAX_SECTIONS = 20;

    //constructors
    public Faculty() {
        super(); // calls Employee()
        this.department = "";
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        this.sectionCount = 0;
    }

    public Faculty(String name, int employeeId, String username, String password,
                   Employee.MyDate hireDate, String department) {
        super(name, employeeId, username, password, hireDate);
        this.department = department;
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        this.sectionCount = 0;
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

    public int getSectionCount() { //return number of faculty was assigned
        return sectionCount;
    }

    public CourseSection getSectionAt(int index) {//return the current section at index, in the list of sections falcuty was assigned
        if (index >= 0 && index < sectionCount) {
            return assignedSections[index];
        }
        else {
            return null;
        }
    }


    //check do falculty themselve can add or remove section by themselve
    //add section
    public boolean addSection(CourseSection section) {
        for (int i = 0; i < sectionCount; i++) { //check for duplicate
            if (assignedSections[i] == section) {
                return false; //already assigned section found
            }
        }

        if (sectionCount >= MAX_SECTIONS) { //falculty can't be hold more than 20 sections
            return false; //cannot add more
        }

        assignedSections[sectionCount] = section;
        sectionCount++;
        return true;
    }

    public int getTotalCredits() {
        int total = 0;
        for (int i = 0; i < sectionCount; i++) {
            CourseSection s = assignedSections[i];
            if (s != null && s.getCourse() != null) {
                total += s.getCourse().getCreditHours();
            }
        }
        return total;
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
            if(//this.getName().equals(otherFaculty.getName()) &&
                //this.getEmployeeId() == otherFaculty.getEmployeeId() &&
                //this.department.equals(otherFaculty.department)
                    super.equals(otherObject) && this.department.equals(otherFaculty.department)) { //check if tthe two namem are equal
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}