package graph;
import java.util.List;
import java.util.ArrayList;
public class CycleDetectionDFS {
    // DFS function to detect cycle
    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, node, visited, graph))
                    return true;
            }
            else if(neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    // Function to check cycle in the graph
    static boolean isCycle(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, visited, graph))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5; // number of vertices
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Adding edges (undirected)
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(1);
        graph.get(1).add(4);
        // Check cycle
        if(isCycle(V, graph))
            System.out.println("Cycle detected in the graph");
        else
            System.out.println("No cycle in the graph");
    }
}
