/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Juan Diego Medina
 */
public class MinIntHeapMain {
    public static void main(String[] args) {
        MinIntHeap myHeap = new MinIntHeap(15);
        myHeap.add(4);
        myHeap.add(10);
        myHeap.add(16);
        myHeap.add(11);
        myHeap.add(14);
        myHeap.add(12);
        myHeap.add(15);
        myHeap.add(8);
        myHeap.add(100);
        myHeap.add(111);
        myHeap.add(112);
        myHeap.deleteMin();
        myHeap.deleteMin();
        for(int i: myHeap.items){
            System.out.println(i+ " ");
        }
    }
}
