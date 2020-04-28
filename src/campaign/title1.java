package campaign;

import java.util.Arrays;

public class title1 {
    public static void main(String[] args) {
        System.out.println(new Solution().expectNumber(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2}));
    }
}


class Solution {
    private int[] ex_n;
    private int[] a; // 全排列数

    public int expectNumber(int[] scores) {
        ex_n = new int[scores.length];
        a = new int[scores.length];
        int Ex = 0;
        Arrays.sort(scores);
        for (int i = 0; i < scores.length; i++) {
            int n = 1;
            while (i < scores.length - 1 && scores[i] == scores[i + 1]) {
                i++;
                n++;
            }
            // System.out.println(calc_ex_n(n));
            Ex += calc_ex_n(n);
        }
        return Ex;
    }

    // n个相同的数期望
    public int calc_ex_n(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (ex_n[n] != 0) return ex_n[n];
        ex_n[n] = (n * 2 + n * 2 * (calc_a(n - 1) - 1)) / calc_a(n);
        return ex_n[n];
    }

    public int calc_a(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (a[n] != 0) return a[n];
        a[n] = n * calc_a(n - 1);
        return a[n];
    }
}