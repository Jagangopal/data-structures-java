package src.main.ds.graph.basics;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphAjacencyListRepresentation {

    public static ArrayList<ArrayList<Integer>> createGraphAdjacencyMatrix(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjMat = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjMat.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjMat.get(u).add(v);
            adjMat.get(v).add(u); // for undirected graph only
        }
        return adjMat;
    }
    public static void main(String[] args){
        int V = 3;
        int[][] edges = {{0,1},{0,2},{1,2}};
        ArrayList<ArrayList<Integer>> adjMat = createGraphAdjacencyMatrix(V, edges);
        for(int i = 0; i < V; i++){
            System.out.print(i+ " ");
            for(int j: adjMat.get(i)){
                System.out.print(j+ " ");
            }System.out.println();
        }
    }
}
