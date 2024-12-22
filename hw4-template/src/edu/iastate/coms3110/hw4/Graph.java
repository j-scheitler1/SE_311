package edu.iastate.coms3110.hw4;

import java.util.Map;

public interface Graph<V> {
    public int vertexCount();

    public Iterable<V> getVertices();

    public Iterable<V> getNeighbors(V v);

    public int edgeCount();

    public void addEdge(V s, V t);

    public void addVertex(V u);

    public boolean hasVertex(V v);

    public boolean hasEdge(V from, V to);

    public Map<V, V> dfs();

    public Tuple<Map<V, Double>, Map<V, V>> dijkstras(V source, Map<Tuple<V, V>, Double> weights);
}
