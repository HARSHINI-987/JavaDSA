package graph;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
class PairP {
    int node;
    int weight;
    PairP(int n, int w) {
        node = n;
        weight = w;
    }
}
public class PrimsMST {
    public static void main(String[] args) {
        int V = 6;
        List<List<PairP>> graph = new ArrayList<>();
        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());
        addEdge(graph,0,1,4);
        addEdge(graph,0,2,4);
        addEdge(graph,1,2,2);
        addEdge(graph,1,3,5);
        addEdge(graph,2,3,8);
        addEdge(graph,2,4,6);
        addEdge(graph,3,4,9);
        addEdge(graph,3,5,10);
        addEdge(graph,4,5,7);
        boolean[] visited = new boolean[V];
        PriorityQueue<PairP> pq =new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new PairP(0,0));
        int mstWeight = 0;
        while(!pq.isEmpty()){
            PairP cur = pq.poll();
            int node = cur.node;
            int weight = cur.weight;
            if(visited[node]) continue;
            visited[node] = true;
            mstWeight += weight;
            System.out.println("Include node: "+node+" weight:"+weight);
            for(PairP neighbor : graph.get(node)){
                if(!visited[neighbor.node]){
                    pq.add(new PairP(neighbor.node,
                            neighbor.weight));
                }
            }
        }
        System.out.println("Total MST Weight = "+mstWeight);
    }
    static void addEdge(List<List<PairP>> graph,int u,int v,int w){
        graph.get(u).add(new PairP(v,w));
        graph.get(v).add(new PairP(u,w));
    }
}
