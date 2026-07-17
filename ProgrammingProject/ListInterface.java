/**
 * College Management System - ListInterface
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: N/A
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public interface ListInterface<D> {
    void add(D item);

    boolean remove(D item);

    boolean find(D item);
}
