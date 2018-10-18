
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.Arrays;

/**
 *
 * @author Juan Diego Medina
 */
public class MinIntHeap {

    private int capacity;
    private int size;
    int[] items;

    public MinIntHeap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.items = new int[initialCapacity];
    }

    private void ensureCapacity() {
        if (size == capacity) {
            this.items = Arrays.copyOf(this.items, this.capacity * 2);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    //para verificar si tiene hijos se mira se usa el indice 
    //del padre y se llama a la funcion getchild, luego se mira
    //si el indice esta dentro del tamano(cada vez que se agrega
    //algo incrementa) del array
    public int getChildLeft(int parentIndex) {
        return this.items[getLeftChildIndex(parentIndex)];
    }

    public int getChildRight(int parentIndex) {
        return this.items[getRightChildIndex(parentIndex)];
    }

    public int getParent(int ChildIndex) {
        return this.items[getParentIndex(ChildIndex)];
    }

    public void add(int item) {
        ensureCapacity();
        this.items[size] = item;
        size++;
        heapUp();
    }

    public int delete() {
        if (this.size == 0) {
            throw new IllegalStateException();
        } else {
            int item = this.items[0];
            this.items[0] = this.items[size - 1];
            size--;
            heapDown();
            return item;
        }
    }

    private boolean hasparent(int childIndex) {
        return getParent(childIndex) >= 0;
    }

    private boolean hasChildLeft(int parentIndex) {
        return getChildLeft(parentIndex) < (size);
    }

    private boolean hasChildRight(int parentIndex) {
        return getChildRight(parentIndex) < (size);
    }

    public void heapUp() {
        int temp = this.size - 1;
        while (hasparent(temp) && getParent(temp) > this.items[temp]) {
            int aux = getParent(temp);
            this.items[getParentIndex(temp)] = this.items[temp];
            this.items[temp] = aux;
            temp = getParentIndex(temp);
        }

    }

    public void heapDown() {
        int temp = 0;
        while (hasChildLeft(temp)) {
            int smallerChild = getLeftChildIndex(temp);
            if (hasChildRight(temp) && getChildRight(temp) < getChildLeft(temp)) {
                smallerChild = getChildRight(temp);
            }
            if(this.items[smallerChild] < this.items[temp]){
                int aux= this.items[temp];
                this.items[temp]=this.items[smallerChild];
                this.items[smallerChild]=aux;
            }else{
                break;
            }
            temp= smallerChild;
        }
    }
}
