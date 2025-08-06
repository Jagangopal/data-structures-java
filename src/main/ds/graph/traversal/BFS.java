package src.main.ds.graph.traversal;

import java.util.*;

public class BFS {
    /**
        Time Complexity: O(V + E)
        Space Complexity: O(V)
     */
    static List<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int v = adj.size();
        int s = 0; //source
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int x: adj.get(current)){
                if(!visited[x]){
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));


        List<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
