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
public class StackNode<T> {
    
    T element;
    StackNode<T> nextNode;

    public StackNode(T element, StackNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public StackNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    
    
}
