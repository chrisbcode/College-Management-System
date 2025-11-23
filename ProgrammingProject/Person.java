import java.time.LocalDate;

/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Person Class
 * Updated: 11.19.25 - 11:21pm
 */

public class Person
{
    
    private String name;
    private LocalDate birthdate;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public Person(String newName, int year, int month, int day) {
        super();
        name = newName;
        birthdate = LocalDate.of(year, month, day);
    }

    
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setBirthDate(int year,  int month, int day) {
        birthdate = LocalDate.of(year, month, day);
    }
    
    public LocalDate getBirthDate() {
        return birthdate;
    }
    
    public String toString(){
        return "Name: " + name + " | Birth date: " + birthdate;
    }
    
       @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false; 
        if(otherObject instanceof Person otherPerson) {
            if(this.name.equals(otherPerson.name) && this.birthdate.equals(otherPerson.birthdate)) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}