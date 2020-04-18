package problem.easy.p121;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Answer {
    public static void main(String[] args) {

    }
}

/**
 * @author caoPhoenix
 * @date 2020/01/06
 * time 61.91% _
 * mem 80.05% _
 * <p>
 * 动态规划，优化存储空间
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxprofit = Math.max(maxprofit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxprofit;
    }
}
