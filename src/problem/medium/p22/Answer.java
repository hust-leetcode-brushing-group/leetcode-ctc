package problem.medium.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Answer {
    public static void main(String[] args) {
        List<String> l = new Solution().generateParenthesis(3);
        System.out.println(l.toString());
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/09
 *
 * 深搜
 */
class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", 0, n, n);
        return list;
    }

    void dfs(String now, int depth, int left, int right) {
        System.out.println(now);
        if (left + right == 0) {
            if (depth == 0) list.add(now);
            return;
        }
        if (left != 0)
            dfs(now + "(", depth + 1, left - 1, right);
        if (depth != 0) {
            dfs(now + ")", depth - 1, left, right - 1);
        }
    }
}

/**
 * @author caoPhoenix
 * @date 2020/01/07
 * time 99.54% _
 * mem 96.80% _
 * <p>
 * 回溯，其实和深搜是一样的
 */
class Solution_2 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backTrack(list, "", n, 0, 0);
        return list;
    }

    public void backTrack(List<String> list, String temp, int max, int left, int right) {
        if (left + right == 2 * max) {
            list.add(temp);
            return;
        }
        if (left < max) {
            backTrack(list, temp + "(", max, left + 1, right);
        }
        if (right < left)
            backTrack(list, temp + ")", max, left, right + 1);
    }
}

