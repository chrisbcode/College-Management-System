/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
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
