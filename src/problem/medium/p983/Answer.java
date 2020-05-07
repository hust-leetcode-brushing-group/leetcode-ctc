package problem.medium.p983;

/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class Answer {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(new Solution().mincostTickets(days, costs));
    }
}

/**
 * @author caoPheonix
 * @date 2020/05/07
 * 执行用时 :1 ms, 在所有 Java 提交中击败了97.23% 的用户
 * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了100.00%的用户
 *
 * 知道是dp，但想不出怎么dp。。。。参考了这篇题解
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/cdong-tai-gui-hua-cong-qian-xiang-hou-tui-dao-geng/
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] passDays = {1, 7, 30};
        int[] dp = new int[366];

        int i = 1;
        for (int day : days) {
            // 非旅行日
            while (i < day) {
                dp[i] = dp[i - 1];
                i++;
            }
            dp[i] = Integer.MAX_VALUE;
            // 旅行日
            for (int j = 0; j < 3; j++) {
                int start = i - passDays[j] < 0 ? 0 : i - passDays[j];
                dp[i] = dp[i] < dp[start] + costs[j] ? dp[i] : dp[start] + costs[j];
            }
            i++;
        }
        return dp[days[days.length - 1]];
    }
}