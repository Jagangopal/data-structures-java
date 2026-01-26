package src.main.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

/**
 * topological sorting of a directed acyclic graph using BFS (Kahn's Algorithm)
 * time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * space Complexity: O(V)
 */
class TopologicalSortingBFSKahnAlg {
    //Driver Code Ends
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] inDegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        //Calculate InDegree
        for(int i = 0; i < n; i++){
            for(int val: adj.get(i)){
                inDegree[val]++;
            }
        }
        System.out.println(Arrays.toString(inDegree));
        // Add all nodes with indegree 0
        // into the queue
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        System.out.println();
        // Kahn’s Algorithm (BFS)
        while(!queue.isEmpty()){
            int poll = queue.poll();
            result.add(poll);
            for(int j: adj.get(poll)){
                inDegree[j]--;
                if(inDegree[j] == 0) queue.add(j);
            }
        }
        return result;
    }
//Driver Code Starts
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 1);
        addEdge(adj, 5, 2);

        ArrayList<Integer> res = topologicalSort(adj);
        for (int vertex : res) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}
//Driver Code Ends
