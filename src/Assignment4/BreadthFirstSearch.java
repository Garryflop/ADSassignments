package Assignment4;
import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(UnweightedGraph<T> graph, T srcData) {
        super(graph.getVertex(srcData));
        bfs();
    }

    private void bfs() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add(source);
        queue.add(source);
        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            for (Vertex<T> w : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
