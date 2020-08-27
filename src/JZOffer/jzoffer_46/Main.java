package JZOffer.jzoffer_46;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(5025));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/9
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了100.00%的用户
 * 【深搜】
 * 每次搜索可以往后 1 个字母或者 2 个字母，搜到结尾则计数 +1
 */
class Solution {

    int count = 0;

    public int translateNum(int num) {
        String number = String.valueOf(num);
        dfs(0, number);
        return count;
    }

    private void dfs(int index, String number) {
        if (index == number.length()) {
            count++;
            return;
        }
        dfs(index + 1, number);

        if (index <= number.length() - 2 && number.charAt(index) != '0' &&
                Integer.parseInt(number.substring(index, index + 2)) < 26) {
            dfs(index + 2, number);
        }
    }
}