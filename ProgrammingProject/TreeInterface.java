/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */

public interface TreeInterface<E>
{
    public abstract void add(E item);
    
    public abstract boolean find(E item);
    
    public abstract boolean remove(E item);
    
}