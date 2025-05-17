package Assignment4;
import java.util.*;

public class UnweightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> vertices = new HashMap<>();

    public UnweightedGraph() {
        this(true);
    }

    public UnweightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T data) {
        vertices.computeIfAbsent(data, Vertex::new);
    }

    public void addEdge(T src, T dest) {
        addVertex(src);
        addVertex(dest);
        Vertex<T> vSrc = vertices.get(src);
        Vertex<T> vDest = vertices.get(dest);
        vSrc.addAdjacent(vDest, 1.0);
        if (undirected) vDest.addAdjacent(vSrc, 1.0);
    }

    public Collection<Vertex<T>> getAllVertices() {
        return vertices.values();
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }
}

