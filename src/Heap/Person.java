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
public class Person implements Comparable<Person> {
    
    int age;
    String name;
    
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age == o.getAge())
            return 0;
        if(this.age < o.getAge())
            return -1;        
        return 1;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name=" + name + '}';
    }
    
    
    
    
    

    
    
}
