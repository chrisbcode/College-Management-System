import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - ArrayBasedList Class
 *
 */

public class ArrayBasedList<D> implements ListInterface<D>
{
    private int numberOfItems;
    private D[] list;

    public ArrayBasedList() {
        super();
        numberOfItems = 0;
        list = (D[])new Object[5];
    }

    public ArrayBasedList(int size) {
        super();
        if(size > 0) {
            list = (D[])new Object[size];
        }
        else {
            list = (D[])new Object[5];
        }
    }

    @Override
    public void add(D item) {
        if(numberOfItems < list.length) {
            list[numberOfItems] = item;
            numberOfItems++;
        }
        else {
            D [] largerList = (D[])new Object[list.length + list.length];
            for(int index = 0; index < list.length; index++) {
                largerList[index] = list[index];
            }
            largerList[numberOfItems] = item;
            numberOfItems++;
            list = largerList;
        }
    }

    @Override
    public boolean find(D item) {
        boolean found = false;
        int index = locate(item);
        if(index != -1) {
            found = true;
        }
        return found;
    }

    private int locate(D item) {
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfItems) {
            if(list[index].equals(item)) {
                found = true;
            }
            else {
                index++;
            }
        }
        if(!found) {
            index = -1;
        }
        return index;
    }

    @Override
    public boolean remove(D item) {
        int index = locate(item);
        boolean removed = false;
        if(index != -1) {
            list[index] = null;
            numberOfItems--;
            list[index] = list[numberOfItems];
            list[numberOfItems] = null;
            removed = true;
        }
        return removed;
    }

    @Override
    public String toString() {
        String allItems = "";
        for(int index = 0; index < numberOfItems; index++) {
            allItems = allItems + "\n" + list[index].toString();
        }
        return allItems;
    }

    public int size() {
        return numberOfItems;
    }

    public Iterator<D> iterator() {
        return new ArrayBasedListIterator();
    }

    private class ArrayBasedListIterator extends Object implements Iterator<D> {

        private int currentLocation;

        public ArrayBasedListIterator() {
            super();
            currentLocation = 0;
        }
        @Override
        public boolean hasNext() {
            return currentLocation < numberOfItems;
        }
        @Override
        public D next() throws NoSuchElementException {
            if(currentLocation >= numberOfItems) {
                throw new NoSuchElementException("Reached the end of the list!");
            }
            else {
                D currentItem = list[currentLocation];
                currentLocation++;
                return currentItem;
            }
        }
    }
}