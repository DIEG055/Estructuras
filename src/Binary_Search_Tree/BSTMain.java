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
public class BSTMain {
    
    public static void main(String args[])
    {
        MyBinarySearchTree<Integer> myBST = new MyBinarySearchTree<>();
        
        myBST.insert(10);
        myBST.insert(1);
        myBST.insert(-3);
        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(5);
        myBST.printInOrden();
        System.out.println("The smallest data is " + myBST.findMin());
        System.out.println("The bigest data is " + myBST.findMax());
        
        myBST.remove(-3);
        System.out.println("The smallest data is " + myBST.findMin());
        
        System.out.println("The tree contains 5? " + myBST.contains(5));
        System.out.println("The tree contains 4? " + myBST.contains(4));
        myBST.remove(10);
       // myBST.remove(2);
            System.out.println("The biggest data is " + myBST.findMax());
            
    }
    
}
