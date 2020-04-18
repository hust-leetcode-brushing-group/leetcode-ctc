package problem.easy.p914;

// leetcode 需要自行 import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Answer {
}

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int x = 0;
        for (int i : map.values()) {
            x = gcd(x, i);
            if (x == 1) return false;   // 一组不能只有1个
        }
        return true;
    }

    // 辗转相除法
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}