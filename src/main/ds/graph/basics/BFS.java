package src.main.ds.graph.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /**
     * Time Complexity: O(V+E)
     * Space Complexity: O(V)
     * @param adj
     * @return
     */
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        int src = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);
            for(int i:adj.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return res;
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        ArrayList<Integer> res = bfs(adj);
        for (int x : res)
            System.out.print(x + " ");
    }
}
