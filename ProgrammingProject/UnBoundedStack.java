/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */
public abstract class UnBoundedStack<T> extends Stack<T>
{
    public UnBoundedStack() {
        super();
    }
    public UnBoundedStack(String name) {
        super(name);
    }

    @Override
    public abstract void push(T item);
}
