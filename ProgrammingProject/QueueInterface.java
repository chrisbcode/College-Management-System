/**
 * College Management System - QueueInterface
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: N/A
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public interface QueueInterface<E> {
    void enqueue(E item) throws QueueFullException;

    E dequeue() throws QueueEmptyException;

    String look();
}
