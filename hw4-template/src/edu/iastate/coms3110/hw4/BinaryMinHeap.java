package edu.iastate.coms3110.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryMinHeap<T> extends PurePriorityQueue<T> {
    private ArrayList<T> heap = new ArrayList<T>();
    private HashMap<T, Integer> location = new HashMap<T, Integer>();

    public BinaryMinHeap(Comparator<T> comp) {
        super(comp);
    }

    /**
     * 
     *
     * @return The number of elements in the heap
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Adds an element to the heap.
     *
     * @param item An element not in the heap that will be added to it.
     */
    @Override
    public void add(T item) {
        heap.addLast(item);
        int index = heap.size() - 1;
        location.put(item, index);
        heapifyUp(index);
    }

    /**
     * 
     *
     * @return Returns the minimum element of the heap without removing it.
     */
    @Override
    public T getMin() {
        return heap.get(0);
    }

    /**
     * Removes the minimum element from the heap and returns it.
     *
     * @return The minimum element that was in the heap when the method was invoked.
     */
    @Override
    public T extractMin() {
        T min = heap.getFirst();
        T last = heap.getLast();

        heap.set(0, last);
        location.put(last, 0);
        location.remove(min);
        heap.remove(heap.size() - 1);

        heapifyDown(0);
        return min;
    }

    /**
     * Anytime the key decreases for an element in the heap, this method must be
     * invoked to restored the heap property. Here, key refers to the value
     * determining the ordering of heap elements as used in the Comparator.
     *
     * @param item An item in the heap that has had its key decreased.
     */
    @Override
    public void keyDecreased(T item) {
        Integer index = location.get(item);
        if (index != null) {
            heapifyUp(index);
        }
    }

    /**
     * Helper method for adding an element
     * @param i
     */
    public void heapifyUp(int i) {
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (comp.compare(heap.get(i), heap.get(parentIndex)) < 0) {
                swap(i, parentIndex);
                i = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Helper method for extracting the min
     * @param i
     */
    public void heapifyDown(int i) {
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int smallest = i;

            if (leftChild < heap.size() && comp.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && comp.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    /**
     * Helper method for swapping during heapifyUp and heapifyDown
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);

        location.put(heap.get(i), i);
        location.put(heap.get(j), j);
    }
}
