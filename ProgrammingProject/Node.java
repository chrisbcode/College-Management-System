/**
 * College Management System - Node
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: Standard node class.
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public class Node<E> {

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
