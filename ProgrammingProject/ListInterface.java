/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */
public interface ListInterface<D>
{
    public abstract void add(D item);

    public abstract boolean remove(D item);

    public abstract boolean find(D item);
}
