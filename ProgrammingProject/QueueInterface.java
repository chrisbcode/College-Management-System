/**
 * @version 7/15/2026
 * <p>
 * Programming Project - College Management System - ArrayBasedList Class
 * <p>
 * Description:
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public interface QueueInterface<E> {
    void enqueue(E item) throws QueueFullException;

    E dequeue() throws QueueEmptyException;

    String look();
}
