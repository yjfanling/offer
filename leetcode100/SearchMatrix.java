package leetcode100;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i< matrix.length && j >=0) {
            int value = matrix[i][j];
            if (target == value) {
                return true;
            } else if (target > value) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
