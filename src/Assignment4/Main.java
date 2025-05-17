package Assignment4;
import java.util.*;

public class Main {
    public static void main(String[] args) {


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

