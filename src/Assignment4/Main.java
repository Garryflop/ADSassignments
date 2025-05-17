package Assignment4;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> wg = new WeightedGraph<>(true);
        wg.addEdge("Almaty", "Astana", 2.1);
        wg.addEdge("Shymkent", "Atyrau", 7.8);
        wg.addEdge("Atyrau", "Astana", 7.1);
        wg.addEdge("Almaty", "Shymkent", 7.2);
        wg.addEdge("Shymkent", "Astana", 3.9);
        wg.addEdge("Astana", "Kostanay", 3.5);
        wg.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:\nPath: " + String.join(" -> ", new DijkstraSearch<>(wg, "Almaty").pathTo("Kyzylorda"))
                + " | Distance: " + new DijkstraSearch<>(wg, "Almaty").distanceTo("Kyzylorda"));

        UnweightedGraph<String> ug = new UnweightedGraph<>(true);
        ug.addEdge("Almaty", "Astana");
        ug.addEdge("Shymkent", "Atyrau");
        ug.addEdge("Atyrau", "Astana");
        ug.addEdge("Almaty", "Shymkent");
        ug.addEdge("Shymkent", "Astana");
        ug.addEdge("Astana", "Kostanay");
        ug.addEdge("Shymkent", "Kyzylorda");

        System.out.println("\nDepth-first search:\nPath: "
                + String.join(" -> ", new DepthFirstSearch<>(ug, "Almaty").pathTo("Kyzylorda")));

        System.out.println("\nBreadth-first search:\nPath: "
                + String.join(" -> ", new BreadthFirstSearch<>(ug, "Almaty").pathTo("Kyzylorda")));
    }
}

