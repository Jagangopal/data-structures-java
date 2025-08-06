package src.main.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotten {

    static boolean isSafe(int i, int j, int m, int n){
        return (i >= 0 && j >=0 && i < m && j < n);
    }
    static int orangesRotting(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        int elapsedTime = 0;
        while(!queue.isEmpty()){
            elapsedTime++;
            int len = queue.size();
            while(len-- > 0){
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                for(int[] dir: directions){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(isSafe(x,y,n,m) && mat[x][y] == 1){
                        mat[x][y] = 2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        // check if any fresh orange is remaining
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, elapsedTime - 1);
    }
    public static void main(String[] args)
    {
        int[][] mat = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1} ,
                {1, 0, 0, 2, 1}};
        System.out.println(orangesRotting(mat));
    }
}
