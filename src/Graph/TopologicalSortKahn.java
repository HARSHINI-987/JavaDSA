package graph;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class TopologicalSortKahn {
    static void topologicalSort(int V, List<List<Integer>> graph) {
        int[] indegree = new int[V];
        // Step 1: Calculate indegree of each node
        for(int i = 0; i < V; i++) {
            for(int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // Step 2: Add nodes with indegree 0
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        System.out.println("Topological Order:");
        // Step 3: Process queue
        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Directed edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        topologicalSort(V, graph);
    }
}
