/**
 * @authors Christopher Bergsveinsson, Anh Vo
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Person Class
 * Updated: 11.18.25 - 12:11am
 */

public class Person extends Object
{
    //instance variable
    private String name;


    //default constructor
    public Person() {
        super(); //call the default constructor from parent class(Object)
        name = "";
    }

    //Overloading constructor
    public Person(String newName) { //newName is a parameter
        super();
        name = newName;
    }

    //getters and setters
    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Person) { //if  there is an object and it is a person
            Person otherPerson = (Person)otherObject; //object type casting,new ref of type person
            if(this.name.equals(otherPerson.name)) { //check if tthe two namem are equal
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }


}
