package src.main.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class WatterJugProblem {
    /**
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     * @param m
     * @param n
     * @param d
     * @return
     */
    public static int minSteps(int m, int n, int d){
        if(d > Math.min(m,n)) return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m + 1][n + 1];
        queue.add(new int[]{0,0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int jug1 = current[0], jug2 = current[1], steps = current[2];
            if(jug1 == d || jug2 == d) return steps;
            //All possible operations
            // 1. Fill Jug1
            if(!visited[m][jug2]){
                visited[m][jug2] = true;
                queue.add(new int[]{m, jug2, steps + 1});
            }
            // 2. Fill Jug2
            if(!visited[jug1][n]){
                visited[jug1][n] = true;
                queue.add(new int[]{jug1, n, steps + 1});
            }
            //3. Empty Jug1
            if(!visited[0][jug2]){
                visited[0][jug2] = true;
                queue.add(new int[]{0, jug2, steps + 1});
            }
            //4. Empty Jug2
            if(!visited[jug1][0]){
                visited[jug1][0] = true;
                queue.add(new int[]{jug1, 0, steps + 1});
            }
            //5. pour jug1 to jug2
            int pour1to2 = Math.min(jug1, n-jug2);
            if(!visited[jug1 - pour1to2][jug2 + pour1to2]){
                visited[jug1 - pour1to2][jug2 + pour1to2] = true;
                queue.add(new int[]{jug1 - pour1to2, jug2 + pour1to2, steps + 1});
            }
            //6. pour jug2 to jug1
            int pour2To1 = Math.min(m-jug1, jug2);
            if(!visited[jug1 + pour2To1][jug2 - pour2To1]){
                visited[jug1 + pour2To1][jug2 - pour2To1] = true;
                queue.add(new int[]{jug1 + pour2To1, jug2 - pour2To1, steps + 1});
            }
        }
        return -1;
    }

    /**
     * execution of inputs
     * @param args
     */
    public static void main(String[] args) {
        // jug1 = 4 litre, jug2 = 3 litre
        int m = 4, n = 3, d = 2;
        System.out.println(minSteps(m, n, d));
    }
}
