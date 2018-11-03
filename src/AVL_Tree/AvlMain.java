
package AVL_Tree;

/**
 *
 * @author Juan Diego Medina
 */
public class AvlMain {

    public static void main(String[] args) {
        //,4,77,20,26,37
        int[] a = {1,2,3,4,5,6,7};
        MyAvlTree<Integer> arbol = new MyAvlTree<>();
        
        System.out.println("-----------------");
        for (int i = 0; i < 6; i++) {
            arbol.insert(i);
        }
//        arbol.insert(3);
//        arbol.insert(4);
//        arbol.insert(6);
//        arbol.insert(5);
//        arbol.insert(2);
        //arbol.insert(1);
        arbol.printpreorder();
        System.out.println("");
        System.out.println("-----------------");

    }
}
