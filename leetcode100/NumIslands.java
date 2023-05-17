package leetcode100;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] !=1 && grid[i][j] =='1' ) {
                    visited[i][j] =1;
                    bsf(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bsf(char[][] grid, int[][] visited, int i, int j) {
        if (i>=grid.length||j>= grid[0].length) {
            return;
        }
        Queue<Point> queue = new LinkedList<>();
        if (j< grid[0].length-1 && grid[i][j+1] =='1' && visited[i][j+1] !=1) {
            queue.add(new Point(i,j+1));
            visited[i][j+1] =1;
        }
        if (j>0 && grid[i][j-1] =='1' && visited[i][j-1] !=1) {
            queue.add(new Point(i,j-1));
            visited[i][j-1] =1;
        }
        if (i< grid.length-1 && grid[i+1][j] =='1' && visited[i+1][j] !=1) {
            queue.add(new Point(i+1,j));
            visited[i+1][j] =1;
        }
        if (i>0 && grid[i-1][j] =='1' && visited[i-1][j] !=1) {
            queue.add(new Point(i-1,j));
            visited[i-1][j] =1;
        }
        while(!queue.isEmpty()){
            Point point = queue.poll();
            bsf(grid,visited,point.x, point.y);
        }
    }

    public int numIslandsDsf(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] =='1' ) {
                    dsf(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dsf(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>= n||grid[i][j]!='1') {
            return;
        }
        grid[i][j]=2;
        dsf(grid,i,j+1);
        dsf(grid,i,j-1);
        dsf(grid,i+1,j);
        dsf(grid,i-1,j);
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}