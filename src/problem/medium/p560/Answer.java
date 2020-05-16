package problem.medium.p560;

public class Answer {
}


/**
 * @author caoPhoenix
 * @date 2020/05/15
 * 执行用时 :413 ms, 在所有 Java 提交中击败了7.09% 的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了7.69%的用户
 *
 * O(n^2)暴力遍历，下面超内存的版本里，其实二维数组并没有必要
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // sums[i][j]为[i,j]的和
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                if ((sum += nums[j]) == k) result++;
            }
        }
        return result;
    }
}


class Solution_1 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // sums[i][j]为[i,j]的和

        return result;
    }
}

/**
 * 超出内存限制
 */
class Solution_x {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // sums[i][j]为[i,j]的和
        int[][] sums = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((sums[i][i] = nums[i]) == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                if ((sums[i][j] = sums[i][j - 1] + nums[j]) == k) result++;
            }
        }
        return result;
    }
}