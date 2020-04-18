package problem.medium.p56;

import java.util.*;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Answer {
}


class Solution {
    class Time implements Comparable<Time> {
        int begin;
        int end;

        Time(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.begin != o.begin ? this.begin - o.begin : this.end - o.end;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1)
            return intervals;
        TreeSet<Time> set = new TreeSet<>();
        for (int[] pair : intervals) {
            set.add(new Time(pair[0], pair[1]));
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (Time time : set) {
            queue.add(new int[]{time.begin, time.end});
            //System.out.println(time.getKey() + ":" + time.getValue());
        }
        queue.add(new int[]{-1, -1});

        while (queue.element()[0] != -1) {
            int[] now = queue.remove();
            int[] tmp = queue.element();
            while (tmp[0] != -1 && tmp[0] <= now[1]) {
                queue.remove();
                now[1] = Integer.max(now[1], tmp[1]);
                tmp = queue.element();
            }
            queue.add(now);
        }
        queue.remove();
        int length = queue.size();
        int[][] result = new int[length][];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.remove();
        }
        return result;
    }
}

/**
 * 队列
 */
class Solution_2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (t1, t2) -> t1[0] != t2[0] ? t1[0] - t2[0] : t1[1] - t2[1]);
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] time : intervals) {
            queue.add(time);
        }
        queue.add(new int[]{-1, -1});

        while (queue.element()[0] != -1) {
            int[] now = queue.remove();
            int[] tmp = queue.element();
            while (tmp[0] != -1 && tmp[0] <= now[1]) {
                queue.remove();
                now[1] = Integer.max(now[1], tmp[1]);
                tmp = queue.element();
            }
            queue.add(now);
        }
        queue.remove();
        int[][] result = new int[queue.size()][];
        for (int i = 0; i < result.length; i++)
            result[i] = queue.remove();
        return result;
    }
}

/**
 * 不用队列，直接遍历
 */
class Solution_3 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1 || intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, (t1, t2) -> t1[0] != t2[0] ? t1[0] - t2[0] : t1[1] - t2[1]);
        ArrayList<int[]> result = new ArrayList<>();
        int begin = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Integer.max(intervals[i][1], end);
            } else {
                result.add(new int[]{begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{begin, end});
        int[][] merged = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            merged[i] = result.get(i);
        }
        return merged;
    }
}


