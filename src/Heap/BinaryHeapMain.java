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
class Persona implements Comparable<Persona> {

    String name;
    int age;
    
    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Persona o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class BinaryHeapMain {
    public static void main(String[] args) {
        BinaryHeap<Integer>  people = new BinaryHeap<>(5);
//        Persona p1 = new Persona("diego", 25);
//        Persona p2 = new Persona("juan", 3);
//        Persona p3 = new Persona("pedro", 5);
//        Persona p4 = new Persona("camilo", 2);
        
        people.insert(25);
        people.insert(3);
        people.insert(5);
        people.insert(2);
        for (int i = 1; i < people.array.length; i++) {
            System.out.println(people.array[i] + " ");
        }
    }
}
