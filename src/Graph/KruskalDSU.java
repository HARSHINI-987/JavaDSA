package Graph;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class EdgeK {
    int src, dest, weight;
    EdgeK(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }
}
public class KruskalDSU {
    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]); // path compression
        return parent[x];
    }
    static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public static void main(String[] args) {
        List<EdgeK> edges = new ArrayList<>();
        edges.add(new EdgeK(0, 1, 4));
        edges.add(new EdgeK(0, 2, 4));
        edges.add(new EdgeK(1, 2, 2));
        edges.add(new EdgeK(1, 3, 5));
        edges.add(new EdgeK(2, 3, 8));
        edges.add(new EdgeK(2, 4, 6));
        edges.add(new EdgeK(3, 4, 9));
        edges.add(new EdgeK(3, 5, 10));
        edges.add(new EdgeK(4, 5, 7));

        // Sort edges using Integer.compare
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));
        for(int i=0;i<edges.size();i++) {
        	System.out.print(edges.get(i).src+" "+edges.get(i).dest+" "+edges.get(i).weight);
        	System.out.println();
        }
        int V = 6;
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        System.out.println("parent[]: " + Arrays.toString(parent));;
        System.out.println("Rank[] : "+Arrays.toString(rank));
        
        for (EdgeK e : edges) {
            int root1 = find(parent, e.src);
            int root2 = find(parent, e.dest);
            if (root1 != root2) {
                System.out.println("Adding edge: " + e.src + " - " + e.dest + " (w=" + e.weight + ")");
                union(parent, rank, root1, root2);
                System.out.println("parent[]: " + Arrays.toString(parent));;
                System.out.println("Rank[] : "+Arrays.toString(rank));
            } else {
                System.out.println("Skipping edge: " + e.src + " - " + e.dest + " (would form cycle)");
            }
        }
    }
}

