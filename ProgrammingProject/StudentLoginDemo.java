
/**
 * Write a description of class StudentLoginDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class StudentLoginDemo
{
    public static void runStudentLogin(Tree<Student> studentTree,
                                        NodeBasedList<Student> studentList,
                                        ArrayBasedList<CourseSection> sectionList){
        Scanner sc = new Scanner(System.in);
        
        //Tree<Student> studentTree = new Tree<Student>();
        //NodeBasedList<Student> studentList = new NodeBasedList<Student>();
        Student info; 
        
        int option;
        do{
            System.out.println("\n===== Welcome to Student Registration System =====");
            System.out.println("1. Create a new account ");
            System.out.println("2. Log in to an existing account ");  
            System.out.println("3. Exit the program");
            System.out.println("Please enter your choice: ");
            option = sc.nextInt();
            sc.nextLine();
            
            if (option == 1 ){
                System.out.println("Enter your first name: ");
                String name = sc.nextLine();
                
                System.out.println("Enter your last name: ");
                String lastName = sc.nextLine();
                
                System.out.println("Enter your birthdate (MM/DD/YYYY): ");
                String birthdate = sc .next();
                
                info = new Student(name , lastName , birthdate );
                
                
                
                if(studentTree.find(info)) { 
                    System.out.println("An account with this information already exsits.");
                    System.out.println("Please log in using your username and password");
                }
                else {
                    System.out.println("\n*** Account Created Successfully ***");
                    System.out.println("Your student account has been created. \n Your ID is: " + info.getID());
                    
                    System.out.println("Create a username");
                    String username = sc .next();
                    System.out.println("Create a password");
                    String password = sc .next();
                    
                    Student s = new Student(name,lastName, birthdate, info.getID(),username, password);
                    
                    info = new Student (username, password);
                    
                    studentTree.add(s);
                    studentList.add(info);
                }

            }
            
            else if (option == 2){
                    System.out.println("Enter your username: ");
                     String username = sc .next();
                    System.out.println("Enter your password");
                    String password = sc .next();
                    Student account = new Student(username, password);
                    //account.setUsername(username);
                    //account.setPassword(password);
                                     
                    if (studentList.login(username, password)){
                        System.out.println("Login successful! Welcome to the Student Information System (SIS).");
                     
                        StudentDemo1.StudentMenu(account, sectionList); //bridge to demo2
                    }
                    else{
                        System.out.println("Invalid username or password. Please try again.");
                    }
            }
               
            else if(option == 3){
                System.out.println("Goodbye");
            }
            
            else{
                System.out.println("Invalid option. Try again!");
            }
            
        }while (option != 3);
        
    }
}