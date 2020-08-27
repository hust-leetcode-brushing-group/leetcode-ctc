package JZOffer.jzoffer_13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
    }
}

// 广搜
class Solution {
    class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int m, int n, int k) {
        int count = 1;

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] visited = new boolean[m][n];

        // 可以用 int[] 代替 Node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 2; i++) {
                int temp_x = node.x + dx[i];
                int temp_y = node.y + dy[i];
                if (temp_x < m && temp_y < n
                        && !visited[temp_x][temp_y]
                        && (temp_x / 10 + temp_x % 10 + temp_y / 10 + temp_y % 10) <= k) {
                    queue.offer(new Node(temp_x, temp_y));
                    visited[temp_x][temp_y] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkSum(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}


// 深搜
class Solution_2 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, 0, 0, m, n, k);
    }

    public int dfs(boolean[][] visited, int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || visited[x][y]
                || (x / 10 + x % 10 + y / 10 + y % 10) > k) return 0;
        visited[x][y] = true;
        return dfs(visited, x + 1, y, m, n, k) + dfs(visited, x, y + 1, m, n, k) + 1;
    }
}