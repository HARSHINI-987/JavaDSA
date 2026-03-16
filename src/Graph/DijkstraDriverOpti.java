package graph;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
class Edge1 {
    int destination, weight;
    Edge1(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
class Graph1 {
    int totalV;
    List<List<Edge1>> adjList;
    Graph1(int totalV) {
        this.totalV = totalV;
        adjList = new ArrayList<>();
        for(int i=0;i<totalV;i++)
            adjList.add(new ArrayList<>());
    }
    void addEdge(int src,int dest,int weight){
        adjList.get(src).add(new Edge1(dest,weight));
        adjList.get(dest).add(new Edge1(src,weight));
    }
    void dijkstra(int src){
        PriorityQueue<Edge1> pq =new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[totalV];
        boolean[] visited = new boolean[totalV];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new Edge1(src,0));
        while(!pq.isEmpty()){
            Edge1 current = pq.poll();
            int u = current.destination;
            if(visited[u])
                continue;
            visited[u] = true;
            System.out.println("Processing node: "+u);
            for(Edge1 neighbor : adjList.get(u)){
                int v = neighbor.destination;
                int weight = neighbor.weight;
                if(!visited[v] && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new Edge1(v,dist[v]));
                }
            }
            System.out.println("dist = "+Arrays.toString(dist));
        }
        System.out.println("\nFinal Shortest Distances:");
        for(int i=0;i<totalV;i++){
            System.out.println("0 → "+i+" = "+dist[i]);
        }
    }
}
public class DijkstraDriverOpti {
    public static void main(String[] args){
        int totalV = 6;
        Graph graph = new Graph(totalV);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,2);
        graph.addEdge(1,4,5);
        graph.addEdge(2,4,3);
        graph.addEdge(2,3,3);
        graph.addEdge(3,5,6);
        graph.addEdge(4,5,1);
        graph.dijkstra(0);
    }
}
