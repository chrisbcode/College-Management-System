/**
 * College Management System - Person
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: Basic person class using localDate for the birthDate attribute.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

import java.time.LocalDate;

public class Person {

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

    public void setBirthDate(int year, int month, int day) {
        birthdate = LocalDate.of(year, month, day);
    }

    public void setBirthDate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public String toString() {
        return "Name: " + name + " | Birth date: " + birthdate;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject instanceof Person otherPerson) {
            if (this.name.equals(otherPerson.name) && this.birthdate.equals(otherPerson.birthdate)) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}