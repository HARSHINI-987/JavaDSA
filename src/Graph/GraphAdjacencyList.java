package Graph;

import java.util.LinkedList;
import java.util.Queue;

//Class to represent the Graph
class GraphAdjacencyList {
 private int vertices; // Number of vertices
 private LinkedList<Integer>[] adjacencyList; // Adjacency list

 // Constructor to initialize the graph
 public GraphAdjacencyList(int vertices) {
     this.vertices = vertices;
     adjacencyList = new LinkedList[vertices];
     for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
     }
 }

 // Method to add an edge to the graph
 public void addEdge(int source, int destination) {
     adjacencyList[source].add(destination);
     adjacencyList[destination].add(source); // For undirected graph
 }

 // Method to display the graph
 public void display() {
     for (int i = 0; i < vertices; i++) {
         System.out.print("Vertex " + i + ":");
         for (int edge : adjacencyList[i]) {
             System.out.print(" -> " + edge);
         }
         System.out.println();
     }
 }

 // Method to perform Breadth-First Search (BFS)
 public void bfs(int startVertex) {
     boolean[] visited = new boolean[vertices];
     Queue<Integer> queue = new LinkedList<>();

     visited[startVertex] = true;
     queue.add(startVertex);

     System.out.print("BFS Traversal: ");
     while (!queue.isEmpty()) {
         int current = queue.poll();
         System.out.print(current + " ");

         for (int neighbor : adjacencyList[current]) {
             if (!visited[neighbor]) {
                 visited[neighbor] = true;
                 queue.add(neighbor);
             }
         }
     }
     System.out.println();
 }

 // Method to perform Depth-First Search (DFS)
 public void dfs(int startVertex) {
     boolean[] visited = new boolean[vertices];
     System.out.print("DFS Traversal: ");
     dfsUtil(startVertex, visited);
     System.out.println();
 }

 // Utility method for DFS
 private void dfsUtil(int vertex, boolean[] visited) {
     visited[vertex] = true;
     System.out.print(vertex + " ");

     for (int neighbor : adjacencyList[vertex]) {
         if (!visited[neighbor]) {
             dfsUtil(neighbor, visited);
         }
     }
 }

 // Main method for testing
 public static void main(String[] args) {
     GraphAdjacencyList graph = new GraphAdjacencyList(5); // Graph with 5 vertices

     graph.addEdge(0, 1);
     graph.addEdge(0, 4);
     graph.addEdge(1, 2);
     graph.addEdge(1, 3);
     graph.addEdge(1, 4);
     graph.addEdge(2, 3);
     graph.addEdge(3, 4);

     System.out.println("Graph Representation (Adjacency List):");
     graph.display();

     System.out.println();
     graph.bfs(0); // Perform BFS starting from vertex 0
     graph.dfs(0); // Perform DFS starting from vertex 0
 }
}

