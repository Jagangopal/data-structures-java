package src.main.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * count the number of islands in a grid
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally, vertically, or diagonally.
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public class CountIslands {
    // Check if the cell (r, c) is valid for BFS traversal
    // It must lie within grid bounds, contain land ('L'), and not be visited yet
    static boolean isSafe(char[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 'L' && !visited[i][j]);
    }

    // Perform BFS to traverse all connected land cells (forming one island)
    static void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        //possible 8 directions
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int k = 0; k < 8; k++){
                int newR = r + dRow[k];
                int newC = c + dCol[k];
                if(isSafe(grid, newR, newC, visited)){
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC});
                }
            }
        }
    }

    // Count the total number of islands in the grid
    static int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        //traverse the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };

        System.out.println(countIslands(grid));
    }
}
