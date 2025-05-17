package Assignment4;
import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> vertices = new HashMap<>();

    public WeightedGraph() { this(true); }
    public WeightedGraph(boolean undirected) { this.undirected = undirected; }

    public void addVertex(T data) { vertices.computeIfAbsent(data, Vertex::new); }

    public void addEdge(T src, T dest, double weight) {
        addVertex(src);
        addVertex(dest);
        Vertex<T> vSrc = vertices.get(src);
        Vertex<T> vDest = vertices.get(dest);
        vSrc.addAdjacent(vDest, weight);
        if (undirected) vDest.addAdjacent(vSrc, weight);
    }

    public Collection<Vertex<T>> getAllVertices() { return vertices.values(); }
    public Vertex<T> getVertex(T data) { return vertices.get(data); }
}
