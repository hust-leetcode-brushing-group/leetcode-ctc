package problem.medium.p210;

import java.util.*;

/**
 * 210. 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class Answer {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {};
        System.out.println(Arrays.toString(new Solution().findOrder(numCourses, prerequisites)));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/10
 * 执行用时 :24 ms, 在所有 Java 提交中击败了32.60% 的用户
 * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了93.33%的用户
 * 【拓扑排序】
 * 将课程的先后顺序看成一张有向图，然后做拓扑排序
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int index = 0;

        // 所有节点的入度
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            // prerequisite[1] -> prerequisite[0]
            inDegree[prerequisite[0]]++;
        }

        // 入度为 0 的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int from = queue.remove();
            result[index++] = from;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == from) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}
