package Assignment4;
import java.util.*;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(UnweightedGraph<T> graph, T srcData) {
        super(graph.getVertex(srcData));
        dfs(source);
    }

    private void dfs(Vertex<T> v) {
        marked.add(v);
        for (Vertex<T> w : v.getAdjacentVertices().keySet()) {
            if (!marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(w);
            }
        }
    }
}
