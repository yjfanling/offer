package leetcode100;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] ==2 ) {
                    queue.add(new Point(i,j));
                } else if (grid[i][j] ==1) {
                    freshCount++;
                }
            }
        }
        while(freshCount > 0 &&!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point point = queue.poll();
                int i = point.x;
                int j = point.y;
                if (j< grid[0].length-1 && grid[i][j+1] ==1 ) {
                    queue.add(new Point(i,j+1));
                    grid[i][j+1] =2;
                    freshCount--;
                }
                if (j>0 && grid[i][j-1] ==1) {
                    queue.add(new Point(i,j-1));
                    grid[i][j-1] =2;
                    freshCount--;
                }
                if (i< grid.length-1 && grid[i+1][j] ==1 ) {
                    queue.add(new Point(i+1,j));
                    grid[i+1][j] =2;
                    freshCount--;
                }
                if (i>0 && grid[i-1][j] ==1) {
                    queue.add(new Point(i-1,j));
                    grid[i-1][j] =2;
                    freshCount--;
                }
            }

        }
        return freshCount == 0 ? time : -1;
    }
}
