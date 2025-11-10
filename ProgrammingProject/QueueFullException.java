/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - QueueFullException
 */

public class QueueFullException extends Exception
{
    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}