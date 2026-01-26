package src.main.ds.graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * graph contains cycle or not in directed graph using BFS (Kahn's Algorithm)
 * time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * Space Complexity: O(V)
 */
public class CycleInDirectedGraph {

    //Driver Code Ends
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        // Compute in-degrees of all vertices
        for(int i = 0; i < V; ++i){
            for(int v: adj.get(i)){
                inDegree[v]++;
            }
        }
        // Add all vertices with in-degree 0 to the queue
        for(int i = 0; i < V; ++i){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        // perform bfs
        while(!queue.isEmpty()){
            int curr = queue.poll();
            visited++;
            for(int v: adj.get(curr)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }

        // If visited nodes != total nodes, a cycle exists
        return visited != V;
    }

    // Function to add an edge to the adjacency list
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args)
    {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        System.out.println(isCyclic(adj) ? "true" : "false");
    }
}