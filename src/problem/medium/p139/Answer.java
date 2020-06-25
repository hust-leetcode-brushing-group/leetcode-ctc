package problem.medium.p139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
public class Answer {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s.substring(0, 7));
    }
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 *
 * @date 2020/06/25
 * 执行用时：10 ms, 在所有 Java 提交中击败了59.97% 的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了8.00% 的用户
 * 【动态规划】 dp[i] 表示子串 [0, i] 是否可以被拆分
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time _ _
 * mem _ _
 *
 * 暴力深搜
 */
class Solution_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, wordDict);
    }

    public boolean dfs(String s, int l, List<String> wordDict) {
        if (l == s.length()) {
            return true;
        }
        for (int r = l; r < s.length(); r++) {
            //System.out.println(s.substring(l,r+1));
            if (wordDict.contains(s.substring(l, r + 1))) {
                //System.out.println(r);
                if (dfs(s, r + 1, wordDict)) return true;
            }
        }
        return false;
    }
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time _ _
 * mem _ _
 *
 * 记忆化深搜
 */
class Solution_3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, new HashSet<String>(wordDict), new Boolean[s.length()]);
    }

    public boolean dfs(String s, int l, HashSet<String> wordDict, Boolean[] memo) {
        if (l == s.length()) {
            return true;
        }
        if (memo[l] != null)
            return memo[l];
        for (int r = l; r < s.length(); r++) {
            System.out.println(s.substring(l, r + 1));
            if (wordDict.contains(s.substring(l, r + 1)) && dfs(s, r + 1, wordDict, memo)) {
                System.out.println(r);
                return memo[r] = true;
            }
        }
        return memo[l] = false;
    }
}


/**
 * @author caoPhoenix
 * @date 2020/6/25
 * 时隔一年，还是只能写出这种超时代码，丢人
 * 直接深搜超时的原因：这样搜索没有标记搜索过的“节点”（此处节点为子串[i, s.length()]）
 * 因此如果加上记录的话，时间复杂度和正常深搜一样：邻接矩阵O(n^2)、邻接表O(n+e)
 */
class Solution_4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, 0, dict);
    }

    private boolean dfs(String s, int start, Set<String> dict) {
        boolean flag = false;
        for (int i = start + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(start, i))) {
                if (i == s.length()) return true;
                flag |= dfs(s, i, dict);
            }
        }
        return flag;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/25
 * 执行用时：15 ms, 在所有 Java 提交中击败了14.29% 的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了8.00% 的用户
 * 【动态规划】写得好捞啊，几乎 O(n^3) 了
 */
class Solution_5 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // dp[i][j] 表示子串 [i, j] 可以被拆分
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i + 1] = dict.contains(s.substring(i, i + 1));
        }
        for (int step = 2; step <= s.length(); step++) {
            for (int i = 0; i <= s.length() - step; i++) {
                int j = i + step;
                if (dict.contains(s.substring(i,j))){
                    dp[i][j] = true;
                    continue;
                }
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][k] && dp[k][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[0][s.length()];
    }
}

