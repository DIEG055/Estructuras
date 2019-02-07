package Heap;

import java.util.Arrays;

/**
 *
 * @author Juan Diego Medina
 */
public class MinHeap<T extends Comparable> {

    int size;
    int capacity;
    T[] items;

    public MinHeap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.items = (T[]) new Comparable[this.capacity + 1];
        this.size = 0;
    }

    public void ensureCapacity() {
        if (this.size == this.capacity) {
            this.capacity = this.capacity * 2 + 1;
            this.items = Arrays.copyOf(this.items, this.capacity);
        }
    }

    public void buildHeap(T[] items) {
        this.size = items.length;
        this.capacity = this.size * 2;
        this.items = (T[]) new Comparable[this.capacity * 2];
        for (int i = 1; i < items.length; i++) {
            this.items[i] = items[i - 1];
        }
        for (int i = this.size / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public void insert(T element) {
        ensureCapacity();
        int hole = this.size + 1;
        this.items[hole] = element;
        int iterator = hole;
        this.size++;
        for (this.items[0] = element; element.compareTo(items[iterator / 2]) < 0; iterator /= 2) {
            this.items[iterator] = this.items[iterator / 2];
        }
        this.items[hole] = element;
    }

    public void deleteMin(T element) {
        this.items[0] = this.items[this.size];
        this.items[this.size] = null;
        this.size--;
        percolateDown(1);
    }

    public void percolateDown(int pos) {
        int iterable = pos;
        this.items[0] = this.items[pos];
        T leftItem = this.items[iterable * 2];
        T rightItem = this.items[(iterable * 2) + 1];
        boolean hasChildren = hasLeftChild(iterable) || hasRightChild(iterable);
        boolean rightComparation = this.items[iterable].compareTo(rightItem) >= 0;
        boolean leftComparation = this.items[iterable].compareTo(leftItem) >= 0;
        while (hasChildren && (rightComparation || leftComparation)) {
            if (leftItem.compareTo(rightItem) < 0) {
                this.items[iterable] = this.items[iterable * 2];
                iterable = iterable * 2;
            } else if (leftItem.compareTo(rightItem) > 0) {
                this.items[pos] = this.items[pos * 2 + 1];
                iterable = pos * 2 + 1;
            }
            hasChildren = hasLeftChild(iterable) || hasRightChild(iterable);
            rightComparation = this.items[iterable].compareTo(rightItem) >= 0;
            leftComparation = this.items[iterable].compareTo(leftItem) >= 0;
        }
    }

    private boolean hasLeftChild(int parentIndex) {
        return (parentIndex * 2) <= this.size;
    }

    private boolean hasRightChild(int parentIndex) {
        return (parentIndex * 2 + 1) <= this.size;
    }
}
