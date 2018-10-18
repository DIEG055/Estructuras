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
public class MyLinkedList<T extends Comparable> extends AbstractList<T> {

    Node<T> root;

    public MyLinkedList() {
        root = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            Node<T> node = root;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        }

        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public T get(int index) {
        return getNode(index).getElement();
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNextNode;
        if (index == size()) {
            newNextNode = null;
        } else {
            newNextNode = getNode(index);
        }

        Node<T> newNode = new Node<>(element, newNextNode, null);

        if (index > 0) {
            Node<T> newBeforeNode = getNode(index - 1);
            newBeforeNode.setNext(newNode);
        } else if (index == 0) {
            root = newNode;
        }
        size++;
    }

    @Override
    public boolean add(T element) {
        add(size(), element);
        return true;
    }

    @Override
    public void set(int index, T element) {
        Node<T> actualNode = getNode(index);
        actualNode.setElement(element);
    }

    @Override
    public T remove(int index) {
        Node<T> removeNode = getNode(index);
        if (index == 0) {
            root = removeNode.getNext();
            removeNode.setNext(null);
        } else {
            Node<T> beforeRemoveNode = getNode(index - 1);
            beforeRemoveNode.setNext(removeNode.getNext());
        }
        size--;
        return removeNode.getElement();
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public void printLinkedList() {
        Node<T> node = root;
        while (node.getNext() != null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }
        System.out.println(node.getElement());
    }

    public void insertTail(T e) {
        Node<T> node = root;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        Node<T> n = new Node<T>(e, null, null);
        node.setNext(n);
    }

    public void inserthead(T e) {
        Node<T> n = new Node<T>(e, root, null);
        root = n;
    }

    public void mergeTwoLists(MyLinkedList a, MyLinkedList b) {
        Node<T> nodeA = a.root;
        Node<T> nodeB = b.root;
        while (nodeA != null && nodeB != null) {
            System.out.println("menor" + (nodeA.getElement()));
            System.out.println("mayor" + (nodeB.getElement()));
            if (nodeA.getElement().compareTo(nodeB.getElement()) < 1) {

                System.out.println(nodeA.getElement());
                nodeA = nodeA.getNext();
            } else if (nodeA.getElement().compareTo(nodeB.getElement()) > 1) {

                System.out.println(nodeB.getElement());
                nodeB = nodeB.getNext();
            } else {
                System.out.println(nodeA.getElement());
                nodeA = nodeA.getNext();
            }
        }
        while (nodeA != null) {
            System.out.println(nodeA.getElement());
            nodeA = nodeA.getNext();
        }
        while (nodeB != null) {
            System.out.println(nodeB.getElement());
            nodeB = nodeB.getNext();
        }
    }
}
