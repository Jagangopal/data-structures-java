package src.main.ds.graph;

import java.util.ArrayList;

/**
 * Detect cycle in a directed graph using DFS
 * Time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * Space Complexity: O(V)
 */
public class DetectCycleInDirectedGraphDFS {

    //Driver Code Ends
    // Utility DFS function to detect cycle in a directed graph
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj,
                                int u, boolean[] visited, boolean[] recStack) {
        if(recStack[u]) return true;
        if(visited[u]) return true;
        recStack[u] = true;
        visited[u] = true;
        for(int v: adj.get(u)){
            if(isCyclicUtil(adj, v, visited, recStack)) return true;
        }
        recStack[u] = false;
        return false;
    }

    // Function to detect cycle in a directed graph
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Run DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recStack))
                return true;
        }
        return false;
    }
//Driver Code Starts

    // Function to add an edge to the adjacency list
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        System.out.println(isCyclic(adj) ? "true" : "false");
    }
}

//Driver Code Ends
