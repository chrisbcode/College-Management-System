/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Employee Class
 * Updated: 11.18.25 - 12:11am
 */

public class Employee extends Person
{

    //instance variable
    private int employeeId; //camel caseing

    //constructors
    public Employee() {
        super();
        this.employeeId = 0;
    }

    public Employee(String newName, int employeeId) {
        super(newName);
        this.employeeId = employeeId;
    }

    //setters and getters
    public void setEmployeeId(int newEmployeeId) {
        if (newEmployeeId > 0) {
            employeeId = newEmployeeId;
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + " | Employee ID: " + employeeId;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject instanceof Employee otherEmployee) {
            if(this.getName().equals(otherEmployee.getName()) &&
                    this.employeeId == otherEmployee.employeeId) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }





}