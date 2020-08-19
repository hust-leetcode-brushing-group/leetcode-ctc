package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                0,
                new TreeNode(
                        1,
                        null,
                        new TreeNode(40, new TreeNode(3, null, null), null)),
                new TreeNode(
                        5,
                        new TreeNode(600, new TreeNode(7, null, null), null),
                        new TreeNode(90, null, new TreeNode(800, null, null)))
        );
        printTree(root);
        /*
                              0
                   /                     \
                  1                       5
                       \             /         \
                       40          600         90
                      /           /               \
                     3           7                800
         */
    }

    private static int cellWidth = 1;

    public static void printTree(TreeNode root) {
        int height = getHeight(root);   // 层数
        int lastNodesNum = (int) Math.pow(2, height - 1); // 最后一层的节点数
        int cellMaxNum = lastNodesNum * 2 - 1;
        int cellNum = cellMaxNum / 2;

        String cell = getCell();
        String leftLine = getLeftLine();
        String rightLine = getRightLine();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int h = 0;
        while (!queue.isEmpty() && h < height) {
            int size = queue.size();
            int dir = 0; // 方向 '/' '\'

            Queue<TreeNode> temp = new LinkedList<>();
            for (int t = 0; t < size; t++) {
                TreeNode node = queue.poll();
                temp.offer(node);
                for (int i = 0; i < cellNum; i++) {
                    System.out.print(cell);
                }
                if (node == null || h == 0) {
                    System.out.print(cell);
                } else if (dir % 2 == 0) {
                    System.out.print(leftLine);
                } else {
                    System.out.print(rightLine);
                }
                dir++;

                for (int i = 0; i <= cellNum; i++) {
                    System.out.print(cell);
                }
            }
            System.out.println();
            for (int t = 0; t < size; t++) {
                TreeNode node = temp.poll();
                for (int i = 0; i < cellNum; i++) {
                    System.out.print(cell);
                }
                if (node == null) {
                    System.out.print(cell);
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    System.out.print(extendString(Integer.toString(node.val)));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                for (int i = 0; i <= cellNum; i++) {
                    System.out.print(cell);
                }
            }
            System.out.println();

            cellNum /= 2;
            h++;
        }
    }

    // 获取二叉树的层数，以及结点内部元素所占位数
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        cellWidth = Integer.max(cellWidth,
                Integer.toString(node.val).length());
        return Integer.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static String getCell() {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 1; i < cellWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    private static String getLeftLine() {
        StringBuilder sb = new StringBuilder("/");
        for (int i = 1; i < cellWidth; i++) {
            sb.insert(0, " ");
        }
        return sb.toString();
    }
    private static String getRightLine() {
        StringBuilder sb = new StringBuilder("\\");
        for (int i = 1; i < cellWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    private static String extendString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = (cellWidth - s.length()) / 2;
        int r = cellWidth - s.length() - l;
        for (int i = 0; i < l; i++) {
            sb.insert(0, " ");
        }
        for (int i = 0; i < r; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
