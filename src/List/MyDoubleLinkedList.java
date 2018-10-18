/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;
/**
 *
 * @author jccas
 * @param <T>
 */
public class MyDoubleLinkedList<T extends Comparable> extends AbstractList<T> {
    
    private Node<T> root;
    private Node<T> tail;
    
    public MyDoubleLinkedList()
    {
        initialize();
    }
    
    private void initialize()
    {
        root = new Node<>(null, null, null);
        tail = new Node<>(null, null, root);
        root.setNext(tail);
        size = 0;        
    }
    
    private Node<T> getNode(int index, boolean toAdd)
    {
        boolean upperBound = (toAdd && index <= size) || (!toAdd && index < size);
        boolean lowerBound = index >=0;
        
        if (lowerBound && upperBound)
        {
            Node<T> node;
            
            if (index < size /2)
            {
                node = root.getNext();
                for (int i = 0; i < index; i++) 
                    node = node.getNext();
            }
            else
            {
                node = tail;
                for (int i = size; i > index; i--) 
                    node = node.getBefore();
            }
            return node;            
        }
                    
        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public T get(int index) {
        return getNode(index, false).getElement();
    }

    @Override
    public boolean add(T element) {
        add(size,element);
        return true;
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNextNode = getNode(index, true);
        Node<T> newBeforeNode = newNextNode.getBefore();         
        Node<T> newNode = new Node<>(element, newNextNode, newBeforeNode);
        newBeforeNode.setNext(newNode);
        newNextNode.setBefore(newNode);
        size++;
    }

    @Override
    public void set(int index, T element) {
        Node<T> actualNode = getNode(index, false);        
        actualNode.setElement(element);
    }

    @Override
    public T remove(int index) {
        Node<T> removeNode = getNode(index, false);
        removeNode.getBefore().setNext(removeNode.getNext());
        removeNode.getNext().setBefore(removeNode.getBefore());
        size--;
        return removeNode.getElement();                
    }

    @Override
    public void clear() {
        initialize();
    }
    
}
