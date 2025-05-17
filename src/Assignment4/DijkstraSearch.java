package Assignment4;
import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> dist = new HashMap<>();
    private final PriorityQueue<Vertex<T>> pq;

    public DijkstraSearch(WeightedGraph<T> graph, T srcData) {
        super(graph.getVertex(srcData));
        pq = new PriorityQueue<>(Comparator.comparingDouble(dist::get));
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<T> graph) {
        for (Vertex<T> v : graph.getAllVertices()) dist.put(v, Double.POSITIVE_INFINITY);
        dist.put(source, 0.0);
        pq.add(source);
        while (!pq.isEmpty()) {
            Vertex<T> u = pq.poll();
            if (marked.contains(u)) continue;
            marked.add(u);
            for (Map.Entry<Vertex<T>, Double> entry : u.getAdjacentVertices().entrySet()) {
                Vertex<T> v = entry.getKey();
                double alt = dist.get(u) + entry.getValue();
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    edgeTo.put(v, u);
                    pq.add(v);
                }
            }
        }
    }

    public double distanceTo(T data) {
        Vertex<T> v = source;
        for (Vertex<T> vert : dist.keySet()) {
            if (vert.getData().equals(data)) { v = vert; break; }
        }
        return dist.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}