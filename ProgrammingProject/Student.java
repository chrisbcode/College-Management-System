/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 * <p>
 * Programming Project - College Management System - ArrayBasedList Class
 * <p>
 * Description:
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Student extends Person implements Comparable<Student> {
    private int studentId;
    private ArrayBasedList<CollegeClass> collegeClasses = new ArrayBasedList<>(10);
    private String username;
    private String password;

    public Student() {
        super();
        studentId = 0;
    }

    public Student(String newName) {
        super(newName);
    }

    public Student(String newName, int newStudentId, LocalDate birthDate) {
        super(newName, birthDate);
        this.studentId = newStudentId;
    }

    public Student(String newName, int newStudentId, LocalDate birthDate, String username, String password) {
        super(newName, birthDate);
        this.studentId = newStudentId;
        this.username = username;
        this.password = password;
    }

    public Student(String newName, int newStudentId, int year, int month, int day) {
        super(newName, year, month, day);
        this.studentId = newStudentId;
    }

    public Student(String newName, int newStudentId) {
        super(newName);
        this.studentId = newStudentId;
    }

    public Student(String fullName, LocalDate birthDate) {
        super(fullName, birthDate);
        this.setBirthDate(birthDate);
    }

    public void setStudentId(int newStudentId) {
        if (newStudentId > 0) {
            studentId = newStudentId;
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addClass(CollegeClass collegeClass) {
        collegeClasses.add(collegeClass);
    }

    public void getClasses() {
        System.out.println(collegeClasses);
    }

    public void removeClass() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(collegeClasses.toString2());
        System.out.println("Which class would you like to remove?");
        int option = keyboard.nextInt();
        CollegeClass collegeClass = collegeClasses.get(option - 1);
        if (collegeClass != null) {
            collegeClass.removeStudent(this);
        }
    }

    public void removeClass(CollegeClass collegeClass) {
        collegeClasses.remove(collegeClass);
    }

    @Override
    public String toString() {
        return super.toString() + " | Student Id: " + studentId;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject instanceof Student otherStudent) {
            if (super.equals(otherObject) &&
                    this.studentId == otherStudent.studentId) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }

    @Override
    public int compareTo(Student other) {

        int result = this.getName().compareTo(other.getName());
        if (result != 0) {
            return result;
        }

        return this.getBirthDate().compareTo(other.getBirthDate());
    }
}
