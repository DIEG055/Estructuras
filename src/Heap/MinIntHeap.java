
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

    int size;
    int capacity;
    int[] items;

    public MinIntHeap(int inicialcapacity) {
        this.capacity = inicialcapacity;
        this.size = 0;
        this.items = new int[inicialcapacity];
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

    private int getLeftChildElement(int parentIndex) {
        return this.items[getLeftChildIndex(parentIndex)];
    }

    private int getrightChildElement(int parentIndex) {
        return this.items[getRightChildIndex(parentIndex)];
    }

    private int getParentElement(int childIndex) {
        return this.items[getParentIndex(childIndex)];
    }

    public void add(int element) {
        ensureCapacity();
        this.items[this.size] = element;
        this.size++;
        moveUp();
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < this.size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < this.size;
    }

    private void moveUp() {
//       al iniciar indexTemp siempre hara referencia al ultimo elemento incluido
        int indexTemp = size - 1;
        while (hasParent(indexTemp) && getParentElement(indexTemp) > this.items[indexTemp]) {
            int temp = this.items[getParentIndex(indexTemp)];
            this.items[getParentIndex(indexTemp)] = this.items[indexTemp];
            this.items[indexTemp] = temp;
            indexTemp = getParentIndex(indexTemp);
        }
    }

    public void deleteMin() {
        int iterable = 0;
        this.items[iterable] = this.items[size - 1];
        this.items[size - 1] = 0;
        this.size--;
        boolean hasChildren = hasLeftChild(iterable) && hasRightChild(iterable);
        boolean leftComparation = this.items[iterable] > getLeftChildElement(iterable);
        boolean rightComparation = this.items[iterable] > getrightChildElement(iterable);
        while (hasChildren && (leftComparation || rightComparation)) {
            if (getLeftChildElement(iterable) < getrightChildElement(iterable)) {
                int temp = this.items[iterable];
                this.items[iterable] = this.items[getLeftChildIndex(iterable)];
                this.items[getLeftChildIndex(iterable)] = temp;
                iterable = getLeftChildIndex(iterable);
            } else {
                int temp = this.items[iterable];
                this.items[iterable] = this.items[getRightChildIndex(iterable)];
                this.items[getRightChildIndex(iterable)] = temp;
                iterable = getRightChildIndex(iterable);
            }
            hasChildren = hasLeftChild(iterable) && hasRightChild(iterable);
        }
    }

}