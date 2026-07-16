/**
 * @version 7/15/2026
 * <p>
 * Programming Project - College Management System - ArrayBasedList Class
 * <p>
 * Description:
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */
public interface ListInterface<D> {
    void add(D item);

    boolean remove(D item);

    boolean find(D item);
}
