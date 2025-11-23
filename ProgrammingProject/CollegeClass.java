import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and Thursday 9:35am → 11:35am
 * Programming Project - College Management System - CollegeClass Class
 */

public class CollegeClass {
    Faculty Professor;
    ArrayBasedList<Student> StudentsInClass;
    ClassWaitlist<Student> StudentWaitlist;

    String ClassName;
    String ClassAbbreviation;
    int ClassID;
    int SectionNumber;
    LocalDateTime ClassTime;
    int creditNumber;

    int sizeOfClass;
    int sizeofWaitlist;


    public CollegeClass() {
        super();
    }

    public CollegeClass(String ClassName, String ClassAbbreviation, int ClassID, int SectionNumber, LocalDateTime ClassTime, int sizeOfClass, int sizeOfWaitlist, int creditNumber) { // constructor for normal usage
        this.ClassName = ClassName;
        this.ClassAbbreviation = ClassAbbreviation;
        this.ClassID = ClassID;
        this.SectionNumber = SectionNumber;
        this.ClassTime = ClassTime;
        this.creditNumber = creditNumber;

        this.sizeOfClass = sizeOfClass;
        this.sizeofWaitlist = sizeOfWaitlist;

        StudentsInClass = new ArrayBasedList<>(sizeOfClass);
        StudentWaitlist = new ClassWaitlist<>(sizeOfWaitlist);
    }

    public CollegeClass(Faculty Professor, String ClassName, int ClassID, int SectionNumber, int hour, int minute, int sizeOfClass, int sizeOfWaitlist, int creditNumber) { // constructor for normal usage
        this.Professor = Professor;
        this.ClassName = ClassName;
        this.ClassID = ClassID;
        this.SectionNumber = SectionNumber;
        this.ClassTime = LocalDateTime.from(LocalTime.of(hour, minute));
        this.creditNumber = creditNumber;

        this.sizeOfClass = sizeOfClass;
        this.sizeofWaitlist = sizeOfWaitlist;

        StudentsInClass = new ArrayBasedList<>(sizeOfClass);
        StudentWaitlist = new ClassWaitlist<>(sizeOfWaitlist);
    }

    public CollegeClass(Faculty Professor, ArrayBasedList<Student> StudentsInClass, ClassWaitlist<Student> StudentWaitlist) { // constructor for quicker data entry
        this.Professor = Professor;
        this.StudentsInClass = StudentsInClass;
        this.StudentWaitlist = StudentWaitlist;
    }

    public CollegeClass(Student[] StudentsInClass, Student[] StudentWaitlist) {
        this.StudentsInClass = new ArrayBasedList<>(StudentsInClass);
        this.StudentWaitlist = new ClassWaitlist<>(StudentWaitlist);
    }


    public void setProfessor(Faculty Professor) {
        this.Professor = Professor;
    }

    public Faculty getProfessor() {
        return Professor;
    }

    public void reassignClass() { // method for full-time professors to reassign class to a part-time professor
        setProfessor(Professor);
    }

    public void addStudent(Student student) {
        if(StudentsInClass.size() < sizeOfClass) {
            StudentsInClass.add(student);
        }
        else if(StudentWaitlist.size() < sizeofWaitlist) {
            try {
                StudentWaitlist.enqueue(student);
            } catch (QueueFullException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Class and waitlist full!");
        }
    }

    public void removeStudent(Student student) {
        
    }

    @Override
    public String toString() {
        return "Course: " + ClassAbbreviation + ClassID + " (" + ClassName + ") | Section:" + SectionNumber + " | Time:" + ClassTime + " | Credits:" + creditNumber + " | Professor:" + Professor;
    }

    public String toString2() {
        return "In Class:\n" + this.StudentsInClass.toString() + "\nIn Waitlist:\n" + this.StudentWaitlist.toString();
    }

}
