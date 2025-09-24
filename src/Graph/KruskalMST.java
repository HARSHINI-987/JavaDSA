package Graph;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class EdgeKrus implements Comparable<EdgeKrus> {
    int src, dest, weight;

    EdgeKrus(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(EdgeKrus other) {
        return this.weight - other.weight; // Sort by weight (Ascending)
    }
}

class GraphKrus {
    int totalV;
    List<EdgeKrus> edges;

    GraphKrus(int totalV) {
        this.totalV = totalV;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new EdgeKrus(src, dest, weight));
    }

    int findParent(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node], parent); // Path compression
        }
        return parent[node];
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int rootU = findParent(u, parent);
        int rootV = findParent(v, parent);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    void kruskalMST() {
        Collections.sort(edges); // Step 1: Sort edges by weight
        int[] parent = new int[totalV];
        int[] rank = new int[totalV];

        for (int i = 0; i < totalV; i++) {
            parent[i] = i; // Initialize each node as its own parent
            rank[i] = 0;
        }

        List<EdgeKrus> mst = new ArrayList<>();
        int mstWeight = 0;

        for (EdgeKrus edge : edges) {
            if (findParent(edge.src, parent) != findParent(edge.dest, parent)) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(edge.src, edge.dest, parent, rank);
            }
        }

        System.out.println("Minimum Spanning Tree (MST) edges:");
        for (EdgeKrus edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Total Weight of MST: " + mstWeight);
    }
}

public class KruskalMST {
    public static void main(String[] args) {
        int totalV = 6;
        GraphKrus graph = new GraphKrus(totalV);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 10);
        graph.addEdge(4, 5, 7);

        graph.kruskalMST();
    }
}
