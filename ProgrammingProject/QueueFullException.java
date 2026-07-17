/**
 * College Management System - QueueFullException
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: N/A
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public class QueueFullException extends Exception {
    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}