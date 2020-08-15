package problem.medium.p424;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 */
public class Main {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(new Solution_1().characterReplacement(s, k));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/15
 * 执行用时：311 ms, 在所有 Java 提交中击败了5.05% 的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了89.65% 的用户
 */
class Solution {
    public int characterReplacement(String s, int k) {
        if (null == s || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int left = 0, right = 0;
        char now = chs[left];
        int t = k;
        int max = 0;
        while (right < chs.length) {
            if (chs[right] == now) {
                right++;
            } else if (t > 0) {
                right++;
                t--;
            } else {
                max = max > (right - left) ? max : (right - left);
                left++;
                if (chs[left] != now) {
                    right = left;
                    t = k;
                    now = chs[left];
                }
            }
        }
        if (t > 0) {
            left -= t;
            left = left >= 0 ? left : 0;
        }
        max = max > (right - left) ? max : (right - left);
        return max;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/15
 * 执行用时：5 ms, 在所有 Java 提交中击败了93.76% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了42.17% 的用户
 */
class Solution_1 {
    public int characterReplacement(String s, int k) {
        if (null == s || s.length() == 0) return 0;
        int[] winCharCount = new int[26];   // 当前窗口中各字母出现的次数
        int historyCharMax = 0; // 当前窗口中次数最多的字母的次数
        int winMax = 0;     // 窗口最大值
        char[] chs = s.toCharArray();
        int left = 0, right = 0;

        while (right < chs.length) {
            int index = chs[right] - 'A';
            winCharCount[index]++;
            historyCharMax = Integer.max(historyCharMax, winCharCount[index]);
            if (historyCharMax + k >= (right - left + 1)) {
                winMax = Integer.max(winMax, right - left + 1);
                right++;
            } else {
                winCharCount[chs[left] - 'A']--;
                left++;
                right++;
            }
        }
        return winMax;
    }
}

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
 */
class Solution_3 {
    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}