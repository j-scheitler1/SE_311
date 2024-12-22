package edu.iastate.coms3110.hw4;

public class Tuple<T, U> {
    public T first; //These were private
    public U second; //These were private

    public Tuple(T a, U b) {
        this.first = a;
        this.second = b;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Tuple<?, ?> other = (Tuple<?, ?>) obj;
        return (this.first == other.first || this.first != null && this.first.equals(other.first))
                && (this.second == other.second || this.second != null && this.second.equals(other.second));
    }

    @Override
    public int hashCode() {
        return first.hashCode() + 31 * second.hashCode();
    }

    public static <T, U> Tuple<T, U> create(T first, U second) {
        return new Tuple<T, U>(first, second);
    }
}
