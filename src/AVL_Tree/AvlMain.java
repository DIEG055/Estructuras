package AVL_Tree;

/**
 * 
 *
 * @author Juan Diego Medina
 */
public class AvlMain {

    public static void main(String[] args) {
        MyAvlTree<Integer> tree = new MyAvlTree<>();
        // insertamos datos
        tree.insert(10);
        tree.insert(24);
        tree.insert(36);
        tree.insert(48);
        tree.insert(7);
        tree.insert(33);
        tree.insert(21);
        tree.insert(17);
        // imprimimos el arbol en preorden para visualizar el balanceo
        System.out.println("Imprimimos el arbol de las 3 formas posibles para evidenciar el balanceo");
        System.out.println("");
        System.out.println("#  Inorder Tree");
        tree.printinorder();
        System.out.println("#  Preorder Tree");
        tree.printpreorder();
        System.out.println("#  Posorder Tree");
        tree.printposorder();
        System.out.println("........................................................................");
        System.out.println("Eliminamos algunos elementos y volvemos a revisar el balanceo");
        System.out.println("removemos: 7, 24, 36");
        tree.remove(7);
        tree.remove(24);
        tree.remove(36);
        System.out.println("");
        System.out.println("#  Inorder Tree");
        tree.printinorder();
        System.out.println("#  Preorder Tree");
        tree.printpreorder();
        System.out.println("#  Posorder Tree");
        tree.printposorder();
        System.out.println("........................................................................");

    }
}
