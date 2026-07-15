/**
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 * @version 7/15/2026
 *
 * Programming Project - College Management System - ArrayBasedList Class
 *
 * Description:
 *
 */

public class TreeNode<E extends Comparable > extends Object 
{
    private E data;
    
    private TreeNode<E> right;
    
    private TreeNode<E> left;

    public TreeNode(E newdata){
    
    data = newdata;
    right = null;
    left = null;    
    }
    
    public void setData(E newData){
        data = newData;
    }
    
    public E getData(){
        return data;
    }
    
    public void setRight(TreeNode<E> OtherRight){
        this.right = OtherRight;
    }
    
    public TreeNode<E> getRight(){
        return right;
    }
    
    public void setLeft(TreeNode<E> OtherLeft){
        this.left = OtherLeft;
    }
    
    public TreeNode<E> getLeft(){
        return left;
    }
}