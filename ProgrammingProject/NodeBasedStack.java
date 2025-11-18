/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - NodeBasedStack Class
 */

public class NodeBasedStack<T> extends UnBoundedStack<T>
{

    private Node<T> top;

    public NodeBasedStack() {
        top = null;
    }
    @Override
    public void push(T item) {
        Node<T> currentNode = new Node<T>(item);
        if(top == null) {
            top = currentNode;
        }
        else {
            currentNode.setLink(top);
            top = currentNode;
        }
    }
    @Override
    public void pop() throws StackEmptyException {
        if(top != null) {
            top = top.getLink();
        }
        else {
            throw new StackEmptyException("Pop attempted on an empty stack!");
        }
    }
    @Override
    public String peek() {
        String topItem;
        if(top != null) {
            topItem = top.getData().toString();
        }
        else {
            topItem = "Stack is empty!";
        }
        return topItem;
    }
}
