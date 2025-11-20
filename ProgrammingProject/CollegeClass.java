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
    int ClassID;
    int SectionNumber;
    String ClassTime; // ex: "9:35am"
    int sizeOfClass;
    int sizeofWaitlist;

    public CollegeClass() {
        super();
    }

    public CollegeClass(Faculty Professor, String ClassName, int ClassID, int SectionNumber, String ClassTime, int sizeOfClass, int sizeOfWaitlist) { // constructor for normal usage
        this.Professor = Professor;
        this.ClassName = ClassName;
        this.ClassID = ClassID;
        this.SectionNumber = SectionNumber;
        this.ClassTime = ClassTime;

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


    private void setProfessor(Faculty Professor) { // private because the reflect method used in the CMS shows admin clearance
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

    public void removeStudentFromClass(Student student) {
        System.out.println(StudentsInClass.remove(student) + " removed");

    }

    public void removeStudentFromWaitlist() {
        try {
            System.out.println(StudentWaitlist.dequeue() +  " removed");
        } catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "In Class:\n" + this.StudentsInClass.toString() + "\nIn Waitlist:\n" + this.StudentWaitlist.toString();
    }

}
