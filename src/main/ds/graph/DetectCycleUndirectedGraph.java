package src.main.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Detect cycle in an undirected graph using BFS
 * Time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * Space Complexity: O(V)
 */
public class DetectCycleUndirectedGraph {

    // Function to perform BFS from node 'start' to detect cycle
    static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new int[]{neighbour, node});
                } else if(neighbour != parent){
                    return true;
                }
            }
        }
        return false;
    }

    // Function to check if the undirected graph contains a cycle
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = 4;
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    // Function to add an edge to the adjacency list
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);

        System.out.println(isCycle(adj) ? "true" : "false");
    }
}

