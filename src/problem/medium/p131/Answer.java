package problem.medium.p131;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time 13.95%
 * mem
 *
 *
 */
class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0);
        else dfs(s, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(String s, List<String> temp, int l)
    {
        if(l==s.length())
        {
            System.out.println(temp);
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int r=l;r<s.length();r++)
        {
            if(isPalindrome(s,l,r))
            {
                temp.add(s.substring(l,r+1));
                dfs(s,temp,r+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int i,int j) {
        while(i<=j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i++;j--;
            }
            else return false;
        }
        return true;
    }
}
