/**
 * @version 7/15/2026
 * <p>
 * Programming Project - College Management System - ArrayBasedList Class
 * <p>
 * Description:
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */
public abstract class UnBoundedStack<T> extends Stack<T> {
    public UnBoundedStack() {
        super();
    }

    public UnBoundedStack(String name) {
        super(name);
    }

    @Override
    public abstract void push(T item);
}
