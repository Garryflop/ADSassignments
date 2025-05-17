package Assignment4;
import java.util.*;

public abstract class Search<T> {
    protected final Set<Vertex<T>> marked = new HashSet<>();
    protected final Map<Vertex<T>, Vertex<T>> edgeTo = new HashMap<>();
    protected final Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
    }

    public boolean hasPathTo(T data) {
        for (Vertex<T> v : marked) {
            if (v.getData().equals(data)) return true;
        }
        return false;
    }

    public List<T> pathTo(T data) {
        Vertex<T> target = null;
        for (Vertex<T> v : marked) {
            if (v.getData().equals(data)) { target = v; break; }
        }
        if (target == null) return Collections.emptyList();
        LinkedList<T> path = new LinkedList<>();
        for (Vertex<T> v = target; !v.equals(source); v = edgeTo.get(v)) {
            path.addFirst(v.getData());
        }
        path.addFirst(source.getData());
        return path;
    }
}
