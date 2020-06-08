package problem.medium.p990;


public class Answer {
    public static void main(String[] args) {
        String[] equations = {
                "e==d", "e==a", "f!=d", "b!=c", "a==b"
        };
        System.out.println(new Solution().equationsPossible(equations));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/8
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了16.67%的用户
 * 【并查集】
 * 感谢并查集的讲解：https://zhuanlan.zhihu.com/p/93647900
 * 本来是遍历每个方程，给变量赋值，用map来维护。提交了好几次才意识到这个思路完全不对。
 * 看了题解之后开始接触并查集，算是并查集的第一道题
 */
class Solution {
    // 表示 每个字母的根节点 对应的位置
    // 每个根表示一类
    private int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                // 不相等的两个变量不应该有相同的根
                if (find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;
    }

    // 合并 TODO 按秩合并
    private void union(int index1, int index2) {
        parent[find(index1)] = find(index2);
    }

    // 查找根 + 压缩路径
    private int find(int index) {
        return parent[index] == index ? index : (parent[index] = find(parent[index]));
    }
}