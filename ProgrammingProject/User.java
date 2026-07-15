/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */

public class User {
    private String username;
    private String password;
    private Faculty faculty;
    private Student student;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Student student) {
        this.username = username;
        this.password = password;
        this.student = student;
    }

    public User(String username, String password, Faculty faculty) {
        this.username = username;
        this.password = password;
        this.faculty = faculty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Faculty getFaculty(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) {
            return faculty;
        }
        return null;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Student getStudent() {
        return student;
    }

    public Student getStudent(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) {
            return student;
        }
        return null;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if(otherObject instanceof User otherStudent) {
            User otherUser = (User) otherStudent;
            if(otherUser.getUsername().equals(this.getUsername()) && otherUser.getPassword().equals(this.getPassword())) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}