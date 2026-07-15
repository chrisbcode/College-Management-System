/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */

public class Node<E>
{

    private E data;
    private Node<E> link;

    public Node(E newData) {
        data = newData;
        link = null;
    }

    public void setData(E newData) {
        data = newData;
    }
    public E getData() {
        return data;
    }
    public void setLink(Node<E> otherNode) {
        this.link = otherNode;
    }
    public Node<E> getLink() {
        return link;
    }
}
