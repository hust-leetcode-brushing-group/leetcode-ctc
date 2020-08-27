package JZOffer.jzoffer_29;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 9, 4, 1},
                {9, 10, 11, 12},
                {55, 0, -1, 10}
        };
        System.out.println(Arrays.toString(new Solution().spiralOrder(matrix)));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/5
 * 执行用时 :2 ms, 在所有 Java 提交中击败了29.84% 的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了100.00%的用户
 * 一圈一圈遍历就行了
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        if (matrix[0].length == 0) return new int[0];
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[][] visited = new boolean[height][width];

        int size = width * height;
        int[] result = new int[size];
        int index = 0, i = 0, j = 0;

        while (index < size) {
            while (j < width && !visited[i][j]) {
                result[index] = matrix[i][j];
                visited[i][j] = true;
                index++;
                j++;
            }
            j--;
            i++;
            while (i < height && !visited[i][j]) {
                result[index] = matrix[i][j];
                visited[i][j] = true;
                index++;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && !visited[i][j]) {
                result[index] = matrix[i][j];
                visited[i][j] = true;
                index++;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && !visited[i][j]) {
                result[index] = matrix[i][j];
                visited[i][j] = true;
                index++;
                i--;
            }
            i++;
            j++;
        }
        return result;
    }
}