package problem.medium.p240;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time 89.21% _
 * mem _ _
 *
 * 剑指Offer 经典题了
 * 从右上角开始往下、往左搜索
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (cols == 0) return false;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) i++;
            else if (target < matrix[i][j]) j--;
        }
        return false;
    }
}