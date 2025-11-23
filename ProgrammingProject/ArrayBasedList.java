

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - ArrayBasedList Class
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

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
            numberOfItems = size;
            list = (D[])new Object[size];
        }
    }

    public ArrayBasedList(D[] list) {
        super();
        this.list = list;
        numberOfItems = list.length;
    }

    @Override
    public void add(D item) {
        if(numberOfItems < list.length) {
            list[numberOfItems] = item;
            numberOfItems++;
        }
        else {
            D [] largerList = (D[])new Object[list.length + list.length];
            System.arraycopy(list, 0, largerList, 0, list.length);
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
        StringBuilder allItems = new StringBuilder();
        for(int index = 0; index < numberOfItems; index++) {
            allItems.append(index + 1).append(" ").append(list[index]).append("\n");
        }
        return allItems.toString();
    }

    public int size() {
        return numberOfItems;
    }

    public Iterator<D> iterator() {
        return new ArrayBasedListIterator();
    }

    private class ArrayBasedListIterator implements Iterator<D> {

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

    public D getList(int index){
            return list[index];
    }
    
}
