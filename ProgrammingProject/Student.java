/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Student Class
 */

public class Student extends Person implements Comparable<Student>
{
    private int studentId;
    String birthDate;

    public Student() {
        super();
        studentId = 0;
    }

    public Student(String newName) {
        super(newName);
    }

    public Student(String newName, int newStudentId, String birthDate) {
        super(newName, birthDate);
        this.studentId = newStudentId;
    }

    public void setStudentId(int newStudentId) {
        if(newStudentId > 0) {
            studentId = newStudentId;
        }
    }
    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return super.toString() + " | Student Id: " + studentId;
    }
    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if(otherObject != null && otherObject instanceof Student) {
            Student otherStudent = (Student)otherObject; //object type casting
            if(super.equals(otherObject) &&
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

    return this.getBirthdate().compareTo(other.getBirthdate());
    }
    }
