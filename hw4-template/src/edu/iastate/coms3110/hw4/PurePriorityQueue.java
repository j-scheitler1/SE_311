package edu.iastate.coms3110.hw4;

import java.util.Comparator;

public abstract class PurePriorityQueue<T> {
    protected Comparator<T> comp;

    protected PurePriorityQueue(Comparator<T> comp) {
        this.comp = comp;
    }

    public abstract int size();

    public abstract void add(T item);

    public abstract T getMin();

    public abstract T extractMin();

    public abstract void keyDecreased(T item);
}
