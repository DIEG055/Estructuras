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
class Person implements Comparable<Person> {

    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class MinHeapMain {

    public static void main(String[] args) {
//        MinHeap<Integer> h = new MinHeap<>(5);
//        h.insert(5);
//        h.insert(4);
//        h.insert(10);
//        h.insert(2);
//        for (int i = 1; i < h.items.length; i++) {
//            System.out.println(h.items[i]+" ");
//        }
        
    Person p1 = new Person("Juan", 18);
    Person p2 = new Person("Diego", 28);
    Person p3 = new Person("Andres", 5);

    MinHeap<Person> personas = new MinHeap<>(5);
    System.out.println("Disponibilidad total de personas " + personas.capacity);
    System.out.println("cantidad de personas "+ personas.size);
    personas.insert(p1);
    personas.insert(p2);
    personas.insert(p3);
    System.out.println("cantidad de personas "+ personas.size);
    System.out.println(personas.items[1].name);
    for(Person p : personas.items){
        System.out.println(p.name);
    }
    }
}
