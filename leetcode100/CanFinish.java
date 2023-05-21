package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjust = new ArrayList<>();
        int[] indgress = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjust.add(new ArrayList<>());
        }
        for (int[] course:prerequisites) {
            indgress[course[0]]++;
            adjust.get(course[1]).add(course[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indgress[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int curr:adjust.get(pre)) {
                indgress[curr]--;
                if (indgress[curr]==0) {
                    queue.add(curr);
                }
            }
        }
        return numCourses==0 ;
    }

    public boolean canFinishDSF(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjust = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjust.add(new ArrayList<>());
        }
        for (int[] course:prerequisites) {
            adjust.get(course[1]).add(course[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dsf(adjust, visited, i)) {
                return false;
            }
        }
        return true ;
    }

    private boolean dsf(List<List<Integer>> adjust, int[] visited, int i) {
        if (visited[i] == 1) {
            return false;
        }
        if (visited[i] == -1){
            return true;
        }
        visited[i] =1;
        for (int pre:adjust.get(i)) {
            if (!dsf(adjust,visited,pre)) {
                return false;
            }
        }
        visited[i] = -1;
        return true;
    }
}
