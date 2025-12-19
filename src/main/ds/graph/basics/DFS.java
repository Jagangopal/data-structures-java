package src.main.ds.graph.basics;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DFS {
    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     * @param adj
     * @param visited
     * @param s
     * @param res
     */
    static void dfsRec(ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, int s, ArrayList<Integer> res)
    {
        visited[s] = true;
        res.add(s);
        for(int i: adj.get(s)){
            if(!visited[i]){
                dfsRec(adj, visited, i, res);
            }
        }
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, visited, 0, res);
        return res;
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args){
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        // Perform DFS starting from vertex 0
        ArrayList<Integer> res = dfs(adj);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
