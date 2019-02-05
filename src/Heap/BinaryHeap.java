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
public class BinaryHeap<T extends Comparable> {

    public int size;
    public T[] array;

    public BinaryHeap() {
        this(0);
    }

    public BinaryHeap(int size) {
        this.size = size;
        this.array = (T[]) new Comparable[this.size + 1];
    }

    public BinaryHeap(T[] items) {
        this.size = items.length;
        this.array = (T[]) new Comparable[(this.size + 2) * 11 / 10];

        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = this.size / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public void insert(T element) {
        if (this.size == this.array.length - 1) {
            enlargeArray(this.array.length * 2 + 1);
        }
        int hole = ++this.size;
        for (array[0] = element; element.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = element;
    }

    public void enlargeArray(int newSize) {
        T[] arrayAux = (T[]) new Comparable[newSize];
        for (int i = 0; i < this.array.length; i++) {
            arrayAux[i] = this.array[i];
        }
        this.array = arrayAux;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T findMin() {
        return this.array[1];
    }

    public T deleteMin() {
        if (isEmpty()) {
            return null;
        }
        T minItem = findMin();
        array[1] = array[this.size--];
        percolateDown(1);
        return minItem;
    }

    private void percolateDown(int hole) {
        int child = 1;
        T tmp = array[hole];

        for (; hole * 2 <= this.size; hole = child) {
            child = hole * 2;
            if ((child != this.size) && (array[child + 1].compareTo(array[child]) < 0)) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

}
