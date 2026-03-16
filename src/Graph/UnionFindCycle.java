package graph;

class UnionFindCycle {
    static int find(int parent[], int node) {
        if(parent[node] == node)
            return node;
        return find(parent, parent[node]);
    }
    static void union(int parent[], int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if(parentX != parentY)
            parent[parentX] = parentY;
    }
    static boolean isCycle(int V, int[][] edges) {
        int[] parent = new int[V];
        for(int i = 0; i < V; i++)
            parent[i] = i;
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int parentU = find(parent, u);
            int parentV = find(parent, v);
            if(parentU == parentV)
                return true;
            union(parent, parentU, parentV);
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {3,4},
                {4,1}
        };
        if(isCycle(V, edges))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycle");
    }
}
