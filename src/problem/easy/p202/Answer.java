package problem.easy.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/04/30
 * 执行用时 : 2 ms , 在所有 Java 提交中击败了 52.10% 的用户
 * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 8.33% 的用户
 * <p>
 * 只能假设没有无限不循环，非快乐数会陷入循环之中。用set保存结果，检索是否是循环即可。
 * <p>
 * 百度百科：
 * 不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
 * 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while (true) {
            sum = 0;
            while (n != 0) {
                int num = n % 10;
                n /= 10;
                sum += num * num;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
        }
    }
}