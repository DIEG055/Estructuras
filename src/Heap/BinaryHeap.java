/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class BinaryHeap<T extends Comparable> {

    private int size;
    private T[] array;

    public BinaryHeap() {
        this.size = 0;
        array = (T[]) new Comparable[10];
    }

    public BinaryHeap(int initialSize) {
        this.size = 0;
        array = (T[]) new Comparable[initialSize];
    }

    private void ensureCapacity(int newCapacity) {
        T[] newArray = Arrays.copyOf(array, newCapacity);
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T item) {
        if (size == array.length - 1) {
            ensureCapacity(array.length * 2);
        }

        int newPosition = ++size;
        for (array[0] = item; item.compareTo(array[newPosition / 2]) < 0; newPosition /= 2) {
            array[newPosition] = array[newPosition / 2];
        }
        array[newPosition] = item;
    }

    public T deleteMin() {
        T min = array[1];
        array[1] = array[size--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int position) {
        int child = 0;
        T tmp = array[position];
        for (; position * 2 <= size; position = child) {
            child = position * 2;
            if (child != size && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[position] = array[child];
            } else {
                break;
            }
        }
        array[position] = tmp;
    }

    //Implementar metodo buildHeap utilizando el algoritmo visto en clase
    public void buildHeap(T[] items) {
        for (int i = 0; i < items.length; i++) {
            insert(items[i]);
        }
        for (int i = this.size / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

}
