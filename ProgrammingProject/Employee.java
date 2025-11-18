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
    private String username;
    private String password;
    private MyDate hireDate;

    //inner class
    public static class MyDate {
        private int month;
        private int day;
        private int year;

        public MyDate(int month, int day, int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public boolean isAfter(MyDate other) {
            if (this.year != other.year)
                return this.year > other.year;
            if (this.month != other.month)
                return this.month > other.month;
            return this.day > other.day;
        }

        @Override
        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }
    //end inner class

    //constructors
    public Employee() {
        super();
        this.employeeId = 0;
        this.username = "";
        this.password = "";
        this.hireDate = new MyDate(1, 1, 2000); // default
    }

    public Employee(String name, int employeeId,
                    String username, String password,
                    MyDate hireDate) {
        super(name);
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.hireDate = hireDate;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }

    public MyDate getHireDate() {
        return hireDate;
    }

    //authentication
    public boolean authenticate(String username, String password) { //can be use to compare the faculty
        return this.username.equals(username) && this.password.equals(password);
    }


    @Override
    public String toString() {
        //return "Name: " + super.getName() + " ,Employee ID: " + employeeId;
        return super.toString() +
                ", Employee ID: " + employeeId +
                ", Username: " + username +
                ", Hire Date: " + hireDate;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Employee) { //if  there is an object and it is a person
            Employee otherEmployee = (Employee)otherObject; //object type casting,new ref of type person
            if(this.getName().equals(otherEmployee.getName()) && //super.equals(otherObject)
                    this.employeeId == otherEmployee.employeeId) { //check if id are equal
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }





}