/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
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
        return "Name: " + this.getName() + " | Employee ID: " + employeeId;
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