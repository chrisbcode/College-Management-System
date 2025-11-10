/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Faculty Class
 */

public class Faculty extends Employee {

    private String department;

    public Faculty() {
        super();
    }

    public Faculty(String name) {
        super(name);
    }

    public Faculty(String name, int employeeId) {
        super(name, employeeId);
    }

    public Faculty(String name, int employeeId, String department) {
        super(name, employeeId);
        this.department = department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return super.toString() + " " + getDepartment();
    }

    @Override
    public boolean equals(Object obj) {
        Faculty faculty = (Faculty) obj;
        return (this.getDepartment().equals(faculty.getDepartment())) && (this.getEmployeeId() == faculty.getEmployeeId()) && (this.getName().equals(faculty.getName()));
    }

}