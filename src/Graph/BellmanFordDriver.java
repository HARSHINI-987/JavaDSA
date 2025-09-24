package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class EdgeBF {
    int src, dest, weight;
    EdgeBF(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class GraphBF {
    int totalV, E;
    List<EdgeBF> edges;

    GraphBF(int totalV, int E) {
        this.totalV = totalV;
        this.E = E;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new EdgeBF(src, dest, weight));
    }

    void bellmanFord(int src) {
        int[] dist = new int[totalV];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < totalV; i++) {
            for (EdgeBF edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }
        System.out.println(Arrays.toString(dist));

        // Detect negative weight cycles
        for (EdgeBF edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
            	dist[edge.dest] = dist[edge.src] + edge.weight;
            	System.out.println(Arrays.toString(dist));
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }

        // Print shortest path distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < totalV; i++) {
            System.out.println("To node " + i + " → Distance: " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }
}

public class BellmanFordDriver {
    public static void main(String[] args) {
        int totalV = 6; // Number of vertices
        int E = 8; // Number of edges
        GraphBF graph = new GraphBF(totalV, E);

        // Graph with negative weight edges
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 5, -6);
        graph.addEdge(4, 5, 1);
        //graph.addEdge(5, 3, 2); // This can form a negative cycle if weight is -8

        graph.bellmanFord(0); // Find shortest paths from node 0
    }
}

