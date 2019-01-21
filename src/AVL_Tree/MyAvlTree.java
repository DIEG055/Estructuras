package AVL_Tree;

/**
 *
 *
 * @author Juan Diego Medina
 */
public class MyAvlTree<T extends Comparable> {

    private MyAvlNode<T> root;

    public MyAvlTree() {
        this.root = null;
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

    private boolean contains(T element, MyAvlNode<T> node) {
        if (node == null) {
            return false;
        }
        int comparable = element.compareTo(node.getElement());
        if (comparable > 0) {
            return contains(element, node.getRight());
        } else if (comparable < 0) {
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

    private MyAvlNode<T> findMin(MyAvlNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() == null) {
            return node;
        } else {
            return findMin(node.getLeft());
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

    private MyAvlNode<T> findMax(MyAvlNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getRight() == null) {
            return node;
        } else {
            return findMax(node.getRight());
        }
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    private MyAvlNode<T> insert(T element, MyAvlNode<T> node) {
        if (node == null) {
            return new MyAvlNode<>(element, null, null);
        }
        int comparable = element.compareTo(node.getElement());
        if (comparable > 0) {
            node.setRight(insert(element, node.getRight()));
        } else if (comparable < 0) {
            node.setLeft(insert(element, node.getLeft()));
        }

        return balance(node);
        // return node;
    }

    //CASO1
    //se realiza una rotacion simple con el nodo izquierdo
    //del nodo alpha, el hijo k1 pasa a ser la raiz, alpha 
    //pasa a ser hijo derecho
    private MyAvlNode<T> rightRot(MyAvlNode<T> alpha) {
        MyAvlNode<T> k1 = alpha.getLeft();
        alpha.setLeft(k1.getRight());
        k1.setRight(alpha);
        //asignamos la profundidad despues de rotar, 
        //la mayor profundidad de sus dos hijos + 1.
        alpha.setHeight(Math.max(height(alpha.getLeft()), height(alpha.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
        return k1;
    }

    //CASO4
    //se realiza una rotacion simple con el nodo derecho
    //del nodo alpha, el hijo k1 pasa a ser la raiz, alpha
    // pasa a ser hijo izquierdo
    private MyAvlNode<T> leftRot(MyAvlNode<T> alpha) {
        MyAvlNode<T> k1 = alpha.getRight();
        alpha.setRight(k1.getLeft());
        k1.setLeft(alpha);
        //asignamos la profundidad despues de rotar
        //la mayor profundidad de sus dos hijos +1.
        alpha.setHeight(Math.max(height(alpha.getLeft()), height(alpha.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
        return k1;
    }

    //CASO2
    //se realiza una rotacion doble:
    //      *rotacion a la izquierda sobre el hijo izquierdo de k2 
    //       del nodo principal(k2).
    //      *luego se rota a la derecha el nodo principal(k2) 
    private MyAvlNode<T> leftRightRot(MyAvlNode<T> alpha) {
        alpha.setLeft(leftRot(alpha.getLeft()));
        return rightRot(alpha);
    }

    //CASO3
    //se realiza una rotacion doble:
    //      *rotacion a la derecha sobre el hijo derecho de k2 
    //       del nodo principal(k2) 
    //      *luego se rota a la izquierda el nodo principal(k2)
    private MyAvlNode<T> rightLeftRot(MyAvlNode<T> alpha) {
        alpha.setRight(rightRot(alpha.getRight()));
        return leftRot(alpha);

    }

    private MyAvlNode<T> balance(MyAvlNode<T> node) {
        if (node == null) {
            return null;
        }
        //revisamos  en que lado esta desbalanceado

        //LADO IZQUIERDO
        if (height(node.getLeft()) - height(node.getRight()) > 1) {
            //revisamos si es caso 1 o caso 2
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                //aplicamos caso 1 
                node = rightRot(node);
            } else {
                //aplicamos caso 2
                node = leftRightRot(node);
            }
            //LADO DERECHO
        } else {
            if (height(node.getRight()) - height(node.getLeft()) > 1) {
                //Revisamos si es caso 3 o caso 4
                if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                    //aplicamos caso 4
                    node = leftRot(node);
                } else {
                    //aplicamos caso 3
                    node = rightLeftRot(node);
                }
            }
        }

        return node;
    }

    private int height(MyAvlNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            int h;
            int heigthR = height(node.getRight());
            int heigthL = height(node.getLeft());
            if (heigthR > heigthL) {
                h = heigthR + 1;
            } else {
                h = heigthL + 1;
            }
            return h;
        }
    }

    public int height() {
        return height(this.root);
    }

    public void remove(T element) {
        if (this.root == null) {
            throw new IndexOutOfBoundsException();
        }
        remove(element, this.root);
    }

    private MyAvlNode<T> remove(T element, MyAvlNode<T> node) {
        if (node == null) {
            return null;
        }
        int result = element.compareTo(node.getElement());
        if (result > 0) {
            node.setRight(remove(element, node.getRight()));
        } else if (result < 0) {
            node.setLeft(remove(element, node.getLeft()));
        } else {
            if (node.getLeft() != null && node.getRight() != null) {
                node.setElement(findMin(node.getRight()).getElement());
                node.setRight(remove(node.getElement(), node.getRight()));
            } else {
                if (node == this.root) {
                    if (this.root.getLeft() == null && this.root.getRight() == null) {
                        this.root = null;
                    } else if (this.root.getLeft() == null) {
                        this.root = this.root.getRight();
                    } else if (this.root.getRight() == null) {
                        this.root = this.root.getLeft();
                    }
                }
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }
        }
        // despues de eliminar un elemento es necesario balancear
        return balance(node);
    }

    public void printinorder() {
        printinorder(this.root);
        System.out.println("");
        System.out.println("");
    }

    private void printinorder(MyAvlNode<T> node) {
        if (node != null) {
            printinorder(node.getLeft());
            System.out.print(node.getElement() + " ");
            printinorder(node.getRight());
        }
    }

    public void printpreorder() {
        printpreorder(this.root);
        System.out.println("");
        System.out.println("");
    }

    private void printpreorder(MyAvlNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " ");
            printpreorder(node.getLeft());
            printpreorder(node.getRight());
        }
    }

    public void printposorder() {
        printposorder(this.root);
        System.out.println("");
        System.out.println("");
    }

    private void printposorder(MyAvlNode<T> node) {
        if (node != null) {
            printposorder(node.getLeft());
            printposorder(node.getRight());
            System.out.print(node.getElement() + " ");

        }
    }
}
