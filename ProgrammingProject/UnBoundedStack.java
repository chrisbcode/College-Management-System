/**
 * College Management System - UnBoundedStack
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: N/A
 * <p>
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
