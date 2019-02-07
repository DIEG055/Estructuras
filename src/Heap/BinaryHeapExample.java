/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author jccas
 */
public class BinaryHeapExample {
    
    public static void main(String[] args) {
        
        Person p1 = new Person(5, "Persona1");
        Person p2 = new Person(7, "Persona2");
        Person p3 = new Person(2, "Persona3");
        Person p4 = new Person(9, "Persona4");
        Person p5 = new Person(14, "Persona5");
        Person p6 = new Person(1, "Persona6");
        Person p7 = new Person(6, "Persona7");
        Person p8 = new Person(4, "Persona8");
        Person p9 = new Person(8, "Persona9");
        
        BinaryHeap<Person> bh = new BinaryHeap<>();
        bh.insert(p1);
        bh.insert(p2);
        bh.insert(p3);
        bh.insert(p4);
        bh.insert(p5);
        bh.insert(p6);
        bh.insert(p7);
        bh.insert(p8);
        bh.insert(p9);
        
        System.out.println(bh.deleteMin().toString());
        System.out.println(bh.deleteMin().toString());
        
        Person[] persons = {p1,p2,p3,p4,p5,p6,p7,p8,p9};
        
        BinaryHeap<Person> bh1 = new BinaryHeap<>();
        bh1.buildHeap(persons);
        
        System.out.println(bh1.deleteMin().toString());
        System.out.println(bh1.deleteMin().toString());
        
        
        
        
    }
    
}
