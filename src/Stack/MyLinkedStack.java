/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author juan.castro
 */
public class MyLinkedStack<T> implements Stack<T> {

    StackNode<T> top;
    int size;
    
    public MyLinkedStack()
    {
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T element) {
        StackNode<T> newNode = new StackNode<>(element, top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        T poppedElement = top.getElement();
        top = top.getNextNode();
        size--;
        return poppedElement;
    }

    @Override
    public T top() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return top.getElement();
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        StackNode<T> n = top;
        while(n != null)        
        {
            System.out.print(n.getElement());
            n = n.getNextNode();
        }
    }
    
}
