/**
 * College Management System - CollegeClass
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: Uses a combination of queue, list and variables to simulate a class and its attributes.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

import java.time.LocalTime;

public class CollegeClass {
    private Faculty Professor;
    private ArrayBasedList<Student> StudentsInClass;
    private ClassWaitlist<Student> StudentWaitlist;

    private String ClassName;
    private String ClassAbbreviation;
    private int ClassID;
    private int SectionNumber;
    private String day;
    private LocalTime ClassTime;
    private int creditNumber;

    private int sizeOfClass;
    private int sizeofWaitlist;


    public CollegeClass() {
        super();
    }

    public CollegeClass(String ClassName, String ClassAbbreviation, int ClassID, int SectionNumber, LocalTime ClassTime, int sizeOfClass, int sizeOfWaitlist, int creditNumber) { // constructor for normal usage
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

    public CollegeClass(String ClassName, String ClassAbbreviation, int ClassID, int SectionNumber, String day, int hour, int minute, int sizeOfClass, int sizeOfWaitlist, int creditNumber) { // constructor for normal usage
        this.ClassName = ClassName;
        this.ClassAbbreviation = ClassAbbreviation;
        this.ClassID = ClassID;
        this.SectionNumber = SectionNumber;

        this.day = day;
        this.ClassTime = LocalTime.of(hour, minute);
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
        this.ClassTime = LocalTime.of(hour, minute);
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

    public CollegeClass(Student[] StudentsInClass) {
        this.StudentsInClass = new ArrayBasedList<>(StudentsInClass);
    }

    public CollegeClass(Student[] StudentsInClass, Student[] StudentWaitlist) {
        this.StudentsInClass = new ArrayBasedList<>(StudentsInClass);
        this.StudentWaitlist = new ClassWaitlist<>(StudentWaitlist);
    }


    public void setProfessor(Faculty Professor) {
        if (this.Professor != null) {
            this.Professor.removeClass(this);
        }
        this.Professor = Professor;
        Professor.addClass(this);
        System.out.println("Professor set");
    }

    public Faculty getProfessor() {
        return Professor;
    }

    public void addStudent(Student student) {
        if (StudentsInClass.size() < sizeOfClass) {
            StudentsInClass.add(student);
            student.addClass(this);
            System.out.println("Added student to class");
        } else if (StudentWaitlist.size() < sizeofWaitlist) {
            try {
                StudentWaitlist.enqueue(student);
                System.out.println("Class full, Added student to waitlist");
            } catch (QueueFullException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Class and waitlist full!");
        }
    }

    public void removeStudent() {
        if (StudentWaitlist.size() > 0) {
            try {
                StudentWaitlist.dequeue();
            } catch (QueueEmptyException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Waitlist is empty!");
        }
    }

    public void removeStudent(Student student) {
        if (StudentsInClass.size() > 0 && StudentsInClass.size() != sizeOfClass) {
            StudentsInClass.remove(student);
            student.removeClass(this);
            System.out.println("Removed student from class");
        } else if (StudentWaitlist.size() > 0 && StudentsInClass.size() == sizeofWaitlist) {
            StudentsInClass.remove(student);
            if (StudentWaitlist.size() > 0) {
                try {
                    Student tempStudent = StudentWaitlist.dequeue();
                    StudentsInClass.add(tempStudent);
                    tempStudent.removeClass(this);
                    System.out.println("Removed student from class, student added to class from waitlist");
                } catch (QueueEmptyException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("Class is empty!");
        }
    }

    public void clearClass() {
       while(StudentsInClass.iterator().hasNext()) {
           Student student = StudentsInClass.iterator().next();
           student.removeClass(this);
           StudentsInClass.remove(student);
       }
       while(StudentWaitlist.size() > 0) {
           try { Student student = StudentWaitlist.dequeue();
           student.removeClass(this);}
           catch (QueueEmptyException _) { }
       }

       if(Professor != null) {
           Professor.removeClass(this);
           Professor = null;
       }

       StudentsInClass = new ArrayBasedList<>();
       StudentWaitlist = new ClassWaitlist<>();
    }

    @Override
    public String toString() {
        return "Course: " + ClassAbbreviation + ClassID + " (" + ClassName + ") | Section:" + SectionNumber + " | Date: " + day + " | Time:" + ClassTime + " | Credits:" + creditNumber + "\nProfessor: " + Professor;
    }

    public String toString2() {
        return ClassAbbreviation + ClassID + "\nIn Class:\n" + this.StudentsInClass.toString() + "\nIn Waitlist:\n" + this.StudentWaitlist.toString();
    }

}
