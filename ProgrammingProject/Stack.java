/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Stack Class
 */

public abstract class Stack<T> extends Object
{

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
