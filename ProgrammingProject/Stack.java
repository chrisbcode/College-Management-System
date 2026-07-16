/**
 * @version 7/15/2026
 * <p>
 * Programming Project - College Management System - ArrayBasedList Class
 * <p>
 * Description:
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public abstract class Stack<T> extends Object {

    private String name;

    public Stack() {
        super();
        name = "";
    }

    public Stack(String stackName) {
        super();
        name = stackName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public abstract void push(T item) throws StackFullException;

    public abstract void pop() throws StackEmptyException;

    public abstract String peek(); //method heading or abstract method
}
