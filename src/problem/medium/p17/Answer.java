package problem.medium.p17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/01/07
 * time 93.73% _
 * mem 74.52% _
 */
class Solution {
    HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;

        LinkedList<String> list = new LinkedList<String>();
        int len = digits.length();
        if (len == 0) {
            return list;
        }
        // 初始内容
        String start = map.get(digits.charAt(0));
        for (int i = 0; i < start.length(); i++) {
            list.add(start.substring(i, i + 1));
        }
        // 开始迭代
        for (int i = 1; i < len; i++) {
            String temp = map.get(digits.charAt(i));
            int l = list.size();
            for (int k = 0; k < l; k++) {
                String kkString = list.poll();
                int step = temp.length();
                for (int j = 0; j < step; j++) {
                    list.offer(kkString + temp.substring(j, j + 1));
                }
            }
        }
        return list;
    }
}