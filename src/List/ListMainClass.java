/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;


import java.util.Iterator;

/**
 *
 * @author jccas
 */
public class ListMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Integer ArrayList        
        IntegerArrayList integerList = new IntegerArrayList();        
        integerList.add(15);
        integerList.add(9);
        integerList.add(-3);
        integerList.add(5);
        System.out.println("Size: " + integerList.size());        
        integerList.print();
        integerList.sort();
        System.out.println("Sorted Array");
        integerList.print();
        
        Iterator<Integer> it = integerList.iterator();
        Integer sum = 0;
        while(it.hasNext())
        {
            sum += it.next();
        }
        System.out.println("Suma: " + sum);
        
        System.out.println("");
//        System.out.println("*****************ARRAY LIST*****************");
//        System.out.println("");
//        
//        //Generic Array List
//        MyArrayList<MyClock> clockList = new MyArrayList<>();        
//        clockList.add(new MyClock(5,35,24));
//        clockList.add(new MyClock(12,2,32));
//        clockList.add(new MyClock(1,12,24));
//        clockList.add(new MyClock(5,35,24));
//        
//        System.out.println("Original Clock Array List");
//        clockList.print();
//        clockList.sort();
//        System.out.println("Sorted Clock Array List");
//        clockList.print();
//        clockList.remove(0);
//        System.out.println("Remove position 0 of Array List");
//        clockList.print();
//        clockList.add(0, new MyClock(23,35,24));
//        System.out.println("Add a new element in position 0 of Array List");
//        clockList.print();
//        clockList.set(1,new MyClock(16,35,55));
//        System.out.println("Set new element in position 1 of Array List");
//        clockList.print();
//        
//        System.out.println("");
        System.out.println("*****************SIMPLE LINKED LIST*****************");
        System.out.println("");
        
        //Generic Simple LinkedList
        MyLinkedList<MyClock> clockList2 = new MyLinkedList<>();        
        clockList2.add(new MyClock(5,35,24));
        clockList2.add(new MyClock(12,2,32));
        clockList2.add(new MyClock(4,12,24));
        clockList2.add(new MyClock(5,35,25));
         MyLinkedList<MyClock> clockList3 = new MyLinkedList<>();        
        clockList3.add(new MyClock(0,35,24));
        clockList3.add(new MyClock(1,2,32));
        clockList3.add(new MyClock(2,12,24));
        clockList3.add(new MyClock(3,35,25));
                System.out.println("PRINT");
        clockList2.printLinkedList();
        System.out.println("PRINT");
        clockList2.mergeTwoLists(clockList2, clockList3);
         
        
//        System.out.println("Original Clock Simple Linked List");
//        clockList2.print();
//        clockList2.sort();
//        System.out.println("Sorted Clock Simple Linked List");
//        clockList2.print();
//        clockList2.remove(0);
//        System.out.println("Remove position 0 of Simple Linked List");
//        clockList2.print();
//        clockList2.add(0, new MyClock(23,35,24));
//        System.out.println("Add a new element in position 0 of Simple Linked List");
//        clockList2.print();
//        clockList2.set(1,new MyClock(16,35,55));
//        System.out.println("Set new element in position 1 of Simple Linked List");
//        clockList2.print();
//        
        System.out.println("");
//        System.out.println("*****************DOUBLE LINKED LIST*****************");
//        System.out.println("");
//        
//        //Generic Double LinkedList with Centinels
//        MyDoubleLinkedList<MyClock> clockList3 = new MyDoubleLinkedList<>();        
//        clockList3.add(new MyClock(5,35,24));
//        clockList3.add(new MyClock(12,2,32));
//        clockList3.add(new MyClock(1,12,24));
//        clockList3.add(new MyClock(5,35,24));
//        System.out.println("Original Clock Double Linked List");
//        clockList3.print();
//        clockList3.sort();
//        System.out.println("Sorted Clock Double Linked List");        
//        clockList3.print();        
//        clockList3.remove(0);
//        System.out.println("Remove position 0 of Double Linked List");
//        clockList3.print();
//        clockList3.add(0, new MyClock(23,35,24));
//        System.out.println("Add a new element in position 0 of Double Linked List");
//        clockList3.print();
//        clockList3.set(1,new MyClock(16,35,55));
//        System.out.println("Set new element in position 1 of Double Linked List");
//        clockList3.print();
//        
        
    }
    
}
