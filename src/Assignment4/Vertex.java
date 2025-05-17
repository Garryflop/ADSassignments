package Assignment4;
import java.util.*;
import java.util.Objects;

public class Vertex<T> {
    private final T data;
    private final Map<Vertex<T>, Double> adjacentVertices = new HashMap<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void addAdjacent(Vertex<T> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return Collections.unmodifiableMap(adjacentVertices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}