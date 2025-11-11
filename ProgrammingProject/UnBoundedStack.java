/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - ClassWaitlist Class
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
