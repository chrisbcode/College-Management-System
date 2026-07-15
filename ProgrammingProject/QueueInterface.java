/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */

public interface QueueInterface<E>
{
    public abstract void enqueue(E item) throws QueueFullException;

    public abstract E dequeue() throws QueueEmptyException;

    public abstract String look();
}
