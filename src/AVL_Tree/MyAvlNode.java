package AVL_Tree;

/**
 *
 *
 * @author Juan Diego Medina
 */
public class MyAvlNode<T> {

    private T element;
    private MyAvlNode<T> left;
    private MyAvlNode<T> right;
    private int height;

    public MyAvlNode(T element) {
        this(element, null, null);
    }

    public MyAvlNode(T element, MyAvlNode<T> left, MyAvlNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyAvlNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyAvlNode<T> left) {
        this.left = left;
    }

    public MyAvlNode<T> getRight() {
        return right;
    }

    public void setRight(MyAvlNode<T> right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int height(MyAvlNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

}
