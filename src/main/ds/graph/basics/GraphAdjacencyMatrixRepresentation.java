package src.main.ds.graph.basics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class GraphAdjacencyMatrixRepresentation {
    /*
     * Representation of Directed Graph as Adjacency Matrix
     * Representation:
     *  0 0 0
     *  1 0 1
     *  1 0 0
     */
    public static ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjMat = new ArrayList<>();
        //Initialize Matrix with Zero
        for(int i = 0; i <= V; i++){
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(V, 0));
            adjMat.add(row);
        }
        //Add each edge to adjacency matrix
        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            adjMat.get(u).set(v, 1);
        }

        return adjMat;
    }
    public static void main(String[] args){
        int V = 3;
        int[][] edges = {{0,1},{0,2},{1,2}};
        // creating directed graph
        ArrayList<ArrayList<Integer>> adjMat = createGraph(V, edges);
        System.out.println("Directed Graph: Adjacency Matrix Representation: ");
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                System.out.print(adjMat.get(i).get(j) + " ");
            } System.out.println();
        }
        // creating undirected graph
        ArrayList<ArrayList<Integer>> adjMatrix = createGraphUndirected(V, edges);
        System.out.println("UnDirected Graph: Adjacency Matrix Representation: ");
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                System.out.print(adjMatrix.get(i).get(j) + " ");
            } System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> createGraphUndirected(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(V, 0));
            adjMatrix.add(row);
        }
        for(int[] itr: edges){
            int u = itr[0];
            int v = itr[1];
            adjMatrix.get(u).set(v, 1);
            adjMatrix.get(v).set(u, 1);
        }
        return adjMatrix;
    }
}
