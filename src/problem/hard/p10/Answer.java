package problem.hard.p10;

public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
    }
}

/**
 * TODO
 * 这鬼题太麻烦了
 */
class Solution {
    char[] chs_s;
    char[] chs_p;

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        else if (s == null || p == null) return false;
        chs_s = s.toCharArray();
        chs_p = p.toCharArray();
        return match(0, 0);
    }

    private boolean match(int i_s, int i_p) {
        if (i_p == chs_p.length && i_s == chs_s.length) return true;
        if (i_p == chs_p.length - 1 && chs_p[i_p] == '*' && i_s == chs_s.length) return true;
        if (i_p >= chs_p.length || i_s >= chs_s.length) return false;
        if (chs_p[i_p] == '*')
            return match(i_s, i_p - 1) || match(i_s, i_p + 1);
        if (chs_p[i_p] == '.' || chs_p[i_p] == chs_s[i_s])
            return match(i_s + 1, i_p + 1)
                    || (i_p < chs_p.length - 1 && chs_p[i_p + 1] == '*' && match(i_s, i_p + 2));
        else return chs_p[i_p + 1] == '*' && match(i_s, i_p + 2); // 当前匹配到不相等
    }
}