package problem.hard.p887;

/**
 * 887. 鸡蛋掉落
 *
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution_2().superEggDrop(2, 6));
    }
}

/**
 * DP  超时
 */
class Solution {
    public int superEggDrop(int K, int N) {
        if (N == 1) return 1;
        else if (N == 2) return 2;
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][2] = 2;
        }
        for (int j = 1; j <= N; j++)
            dp[1][j] = j;

        for (int i = 2; i <= K; i++) {
            for (int j = 3; j <= N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 2; k <= j - 1; k++) {
                    int worst = Integer.max(dp[i][j - k], dp[i - 1][k - 1]);
                    min = Integer.min(min, worst);
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[K][N];
    }
}

/**
 * 二分查找 优化DP 通过
 */
class Solution_2 {
    public int superEggDrop(int K, int N) {
        if (N == 1) return 1;
        else if (N == 2) return 2;
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][2] = 2;
        }
        for (int j = 1; j <= N; j++)
            dp[1][j] = j;

        for (int i = 2; i <= K; i++) {
            for (int j = 3; j <= N; j++) {
                // 二分找出使 dp[i - 1][k - 1] <= dp[i][j - k] 的最大 k
                int left = 2, right = j, k;
                while (left + 1 < right) {
                    k = (left + right) / 2;
                    if (dp[i - 1][k - 1] <= dp[i][j - k]) {
                        left = k;
                    } else if (dp[i - 1][k - 1] > dp[i][j - k]) right = k;
                }
                //System.out.println("N=" + j + "递减的：" + dp[i][j - k] + ",递增的：" + dp[i - 1][k - 1]);
                dp[i][j] = Integer.min(dp[i][j - left], dp[i - 1][(left + 1) - 1]) + 1;
            }
        }
        return dp[K][N];
    }
}