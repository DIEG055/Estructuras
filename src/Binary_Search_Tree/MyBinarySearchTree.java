
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Search_Tree;

/**
 *
 * @author jccas
 */
public class MyBinarySearchTree<T extends Comparable> {

    private MyBinaryNode<T> root;

    public MyBinarySearchTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T element) {
        return contains(element, root);
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    private MyBinaryNode<T> insert(T element, MyBinaryNode<T> node) {
        if (node == null) {
            return new MyBinaryNode<>(element, null, null);
        }
        int compareResult = element.compareTo(node.getElement());
        if (compareResult < 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else if (compareResult > 0) {
            node.setRight(insert(element, node.getRight()));
        }

        return node;
    }

    private boolean contains(T element, MyBinaryNode<T> node) {
        if (node == null) {
            return false;
        }

        int compareResult = element.compareTo(node.getElement());

        if (compareResult < 0) {
            return contains(element, node.getLeft());
        } else if (compareResult > 0) {
            return contains(element, node.getRight());
        } else {
            return true;
        }
    }

    public T findMin() {
        if (isEmpty()) {
            System.out.println("Tree empty");
            return null;
        } else {
            return findMin(root).getElement();
        }
    }

    public T findMax() {
        if (isEmpty()) {
            System.out.println("Tree empty");
            return null;
        } else {
            return findMax(root).getElement();
        }
    }

    private MyBinaryNode<T> findMin(MyBinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() == null) {
            return node;
        } else {
            return findMin(node.getLeft());
        }
    }

    private MyBinaryNode<T> findMax(MyBinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getRight() == null) {
            return node;
        } else {
            return findMax(node.getRight());
        }
    }

    public void remove(T elem) {
        if (root == null) {
            throw new IndexOutOfBoundsException();
        }
        remove(elem, root);
    }

    private MyBinaryNode<T> remove(T elem, MyBinaryNode<T> n) {
        if (n == null) {
            return null;
        }
        int result = elem.compareTo(n.getElement());
        if (result > 0) {
            n.setRight(remove(elem, n.getRight()));
        } else if (result < 0) {
            n.setLeft(remove(elem, n.getLeft()));
        } else {
            if (n.getLeft() != null && n.getRight() != null) {
                n.setElement(findMin(n.getRight()).getElement());
                n.setRight(remove(n.getElement(), n.getRight()));
            } else {
                if (n == root) {
                    if (root.getLeft() == null && root.getRight() == null) {
                        root = null;
                    } else if (root.getLeft() == null) {
                        root = root.getRight();
                    } else if (root.getRight() == null) {
                        root = root.getLeft();
                    }
                }
                n = (n.getLeft() != null) ? n.getLeft() : n.getRight();
            }
        }
        return n;
    }
//imprimir en Inorden

    public void printInOrden() {
        System.out.print("InOrden: ");
        printInOrden(this.root);
        System.out.println("");
    }

    private void printInOrden(MyBinaryNode<T> n) {
        if (n != null) {
            printInOrden(n.getLeft());
            System.out.print(n.getElement() + " ");
            printInOrden(n.getRight());
        }

    }
}
