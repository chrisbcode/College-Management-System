/**
 * College Management System - Employee
 * <p>
 * @version 7/15/2026
 * <p>
 * Description: Derived from person, simulates an employee and their attributes.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public class Employee extends Person {

    private int employeeId;

    public Employee() {
        super();
        this.employeeId = 0;
    }

    public Employee(String newName, int employeeId) {
        super(newName);
        this.employeeId = employeeId;
    }

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
            if (this.getName().equals(otherEmployee.getName()) &&
                    this.employeeId == otherEmployee.employeeId) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }


}