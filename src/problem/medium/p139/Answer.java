package problem.medium.p139;

import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time 60.41% _
 * mem _ _
 *
 * 动态规划
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for(int i=1;i<=len;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] == true && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
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
        return dfs(s,0,wordDict);
    }

    public boolean dfs(String s, int l, List<String> wordDict)
    {
        if(l==s.length())
        {
            return true;
        }
        for(int r=l;r<s.length();r++)
        {
            //System.out.println(s.substring(l,r+1));
            if(wordDict.contains(s.substring(l,r+1)))
            {
                //System.out.println(r);
                if(dfs(s,r+1,wordDict)) return true;
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
        return dfs(s,0,new HashSet<String>(wordDict),new Boolean[s.length()]);
    }

    public boolean dfs(String s, int l, HashSet<String> wordDict, Boolean[] memo)
    {
        if(l==s.length())
        {
            return true;
        }
        if(memo[l]!=null)
            return memo[l];
        for(int r=l;r<s.length();r++)
        {
            System.out.println(s.substring(l,r+1));
            if(wordDict.contains(s.substring(l,r+1)) && dfs(s,r+1,wordDict,memo))
            {
                System.out.println(r);
                return memo[r]=true;
            }
        }
        return memo[l]=false;
    }
}