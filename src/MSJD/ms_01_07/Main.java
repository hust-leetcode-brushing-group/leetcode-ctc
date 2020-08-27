package MSJD.ms_01_07;

import java.util.Arrays;

/**
 * 面试题 01.07. 旋转矩阵
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */
public class Main {
    public static void main(String[] args) {
        int[][] martix = new int[][]
                {
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                };
        new Solution().rotate(martix);
        System.out.println(Arrays.deepToString(martix));
    }
}


class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 角矩形长宽
        int height = N / 2;
        int width = N % 2 == 0 ? N / 2 : N / 2 + 1;

        // 换角
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i]; // 左下角对应的位置
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j]; // 右下角对应的位置
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i]; // 右上角对应的位置
                matrix[j][N - 1 - i] = temp;
            }
        }
    }
}