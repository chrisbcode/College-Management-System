/**
 * College Management System - ClassWaitlist
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: An array based queue.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public class ClassWaitlist<E> implements QueueInterface<E> {

    private E[] items;

    public ClassWaitlist() {
        super();
    }

    public ClassWaitlist(int size) {
        items = (E[]) new Object[size];
    }

    public ClassWaitlist(E[] items) {
        super();
        this.items = items;
    }

    public int size() { // method to eliminate redundant length checks
        int i;

        for (i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return i;
            }
        }

        return i;
    }

    @Override
    public void enqueue(E item) throws QueueFullException {
        if (size() >= items.length) {
            throw new QueueFullException("Queue is full!");
        } else {
            items[size()] = item;
        }

    }

    @Override
    public E dequeue() throws QueueEmptyException {
        E dequeuedItem = null;
        if (size() <= 0) {
            throw new QueueEmptyException("Queue is empty!");
        } else {
            dequeuedItem = items[0];

            for (int i = 0; i < size() - 1; i++) {
                items[i] = items[i + 1];
            }

            items[size() - 1] = null;
        }
        return dequeuedItem;
    }

    @Override
    public String look() {
        if (size() <= 0) {
            return "Queue is empty";
        } else
            return items[0].toString();
    }

    @Override
    public String toString() {
        StringBuilder listContents = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            listContents.append(items[i]).append("\n");
        }
        return listContents.toString();
    }


}