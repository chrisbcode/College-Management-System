/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Student Class
 */
/**
public class Student extends Person
{
    private int studentId;

    public Student() {
        super();
        studentId = 0;
    }
    public Student(String newName) {
        super(newName);
        studentId = 0;
    }
    public Student(String newName, int newStudentId) {
        super(newName);
        if(newStudentId > 0) {
            studentId = newStudentId;
        }
        else {
            studentId = 0;
        }
    }
    public Student(int newStudentId) {
        super();
        if(newStudentId > 0) {
            studentId = newStudentId;
        }
        else {
            studentId = 0;
        }
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
}
**/

public class Student extends Person implements Comparable<Student>
{
   private int studentId;
   
   private String username;
   
   private String password;
   
   private static int ID = 1233;
   
   private ArrayBasedList<Course> myCourse;
   
   public Student(){
       super();
       studentId = 0;
       
       username = "";
       
       password = "";
       
       myCourse = new ArrayBasedList<Course> (10);

   }
   
    public Student(String name, String lastName, String bdate){
       super(name,lastName, bdate);
       
       username = "";
       
       password = "";
       
   }
   
   public Student(String name, String lastName, String bdate, int newStudentId, String newUsername, String newPassword){
       super(name,lastName, bdate);
       
       studentId = 0;
       
       username = "";
       
       password = "";
       
   }
   
   
   public Student ( String newName , int newStudentId, String newUsername, String newPassword){
       super();
       super.setName(newName);
       if (newStudentId > 0 ){
           studentId = newStudentId;
       }
       username = newUsername;
       password = newPassword;
   }
   
   public Student (String newUsername, String newPassword){
       username = newUsername;
       password = newPassword;
   }
   
   
   public void setStudentId(int newStudentId){
       if (newStudentId > 0 ){
           studentId = newStudentId;
       }else{
           studentId = 0;
       }
   }
   
   public int getStudentId (){
       return studentId;
   }
   
   
   public void setUsername(String newUsername){
       username = newUsername;
   }
   
   public String getUsername(){
       return username;
   }
   
   public void setPassword(String newPassword){
       password = newPassword;
   }
   
   public String getPassword (){
       return password;
   }
     
   
   
   public String toString(){
       return super.getName() + " Student ID " + studentId + " Username " + username + " Password " + password ;
   }
   
   @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;

        if (otherObject != null && otherObject instanceof Student) {
            Student otherStudent = (Student) otherObject;

               if (this.username != null && this.password != null &&
                otherStudent.username != null && otherStudent.password != null &&
                this.username.equals(otherStudent.username) &&
                this.password.equals(otherStudent.password)) {
            
                areTheyEqual = true;
            }
        }

    return areTheyEqual;
    }
   
      public void addCourse(Course newCourse) {

    boolean duplicate = false;
    int i = 0;

    
    while (i < myCourse.numberOfItems) {

        Course c = myCourse.getList(i); 

        if (c.getSubjectCode().equals(newCourse.getSubjectCode())) {

            duplicate = true;
        }

        i++;   
    }

    if (!duplicate) {
        myCourse.add(newCourse);
        System.out.println("Class added successfully!");
    } else {
        System.out.println("You already registered for this class!");
    }
 
   }
    
   public void dropCourse(Course myClass) { 
        myCourse.remove(myClass);
   }
    
   public String viewMyCourses() { 
      return myCourse.toString();
   }

   
   public static int getID(){
    ID++;
    return ID;
    }
   
       @Override
    public int compareTo(Student other) {
        // Compare last name first
        int result = this.getLastName().compareTo(other.getLastName());
        if (result != 0) {
            return result;
        }

        // Then first name
        result = this.getName().compareTo(other.getName());
        if (result != 0) {
            return result;
        }

        // Then birthdate (as String is fine if format is the same)
        return this.getBirthdate().compareTo(other.getBirthdate());
    }   


}