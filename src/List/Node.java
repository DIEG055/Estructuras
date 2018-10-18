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
public class Node<T> {
    
    T element;
    Node<T> next;
    Node<T> before;

    public Node(T element, Node<T> nextElement, Node<T> before) {
        this.element = element;
        this.next = nextElement;
        this.before = before;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public Node<T> getBefore() {
        return before;
    }

    public void setBefore(Node<T> before) {
        this.before = before;
    }
    
}
