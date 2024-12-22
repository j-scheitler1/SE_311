package edu.iastate.coms3110.hw4;

public class Edge<V> {
    protected V s;
    protected V t;

    public Edge(V source, V target) {
        this.s = source;
        this.t = target;
    }

    public V getSource() {
        return s;
    }

    public V getTarget() {
        return t;
    }

    @Override
    public String toString() {
        return "(" + s + "," + t + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Edge<?> other = (Edge<?>) obj;
        if (this.s == other.s && this.t == other.t)
            return true;
        else
            return (this.s != null && this.s.equals(other.s)) && (this.t != null && this.t.equals(other.t));
    }

    @Override
    public int hashCode() {
        return s.hashCode() + 31 * t.hashCode();
    }
}
