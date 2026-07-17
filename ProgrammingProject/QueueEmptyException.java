/**
 * College Management System - QueueEmptyException
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: N/A
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
