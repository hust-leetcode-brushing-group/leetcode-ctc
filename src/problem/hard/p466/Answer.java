package problem.hard.p466;

/**
 * 466. 统计重复个数
 * https://leetcode-cn.com/problems/count-the-repetitions/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().getMaxRepetitions(
                "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikef",
                1000000,
                "fmznimkkasvwsrenzkycxfxtlsgypsfad",
                333
        ));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/19
 *
 * 在 _1 的基础上改过来，这次超时了
 * 第31/41个通过测试用例
 * "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikef"
 * 1000000
 * "fmznimkkasvwsrenzkycxfxtlsgypsfad"
 * 333
 *
 * 结果是333是对的，527ms也超时，我不玩了
 */
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int len_S1 = chs1.length * n1;
        int len_S2 = chs2.length * n2;
        // S1 -> S2 M
        int M = 0;
        int point1 = 0;
        boolean hit = false;
        while (point1 < len_S1) {
            for (int i = 0; i < len_S2; i++) {
                hit = false;
                for (; point1 < len_S1; point1++) {
                    if (chs1[point1 % chs1.length] == chs2[i % chs2.length]) {
                        hit = true;
                        break;
                    }
                }
                // S1扫完都没匹配，说明不能获得
                if (!hit) {
                    // System.out.println("不匹配");
                    return M;
                }
                // 此时hit = true. 若S1扫完时，S2都还没走到尾，说明也不能转换
                if (point1 == len_S1 - 1 && i < len_S2 - 1) {
                    // System.out.println("S1扫完了" + i);
                    return M;
                }
                point1++;
            }
            // 到这里，S2 能够扫描完，说明S1可以获得S2，开始计算M
            // S1 [0, point1] 可以得到 S2
            M++;
        }
        return M;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/19
 *
 * 直接拼字符串会超出内存限制
 */
class Solution_2 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 转换成 char[] 访问快
        char[] string1 = s1.toCharArray();
        char[] string2 = s2.toCharArray();
        // 字符串 S1 S2
        char[] chs1 = new char[string1.length * n1];
        char[] chs2 = new char[string2.length * n2];
        for (int i = 0; i < chs1.length; i++) {
            chs1[i] = string1[i % string1.length];
        }
        for (int i = 0; i < chs2.length; i++) {
            chs2[i] = string2[i % string2.length];
        }

        // S1 -> S2 M
        int M = 0;
        int point1 = 0;
        boolean hit = false;
        while (point1 < chs1.length) {
            for (int i = 0; i < chs2.length; i++) {
                hit = false;
                for (; point1 < chs1.length; point1++) {
                    if (chs1[point1] == chs2[i]) {
                        hit = true;
                        break;
                    }
                }
                // S1扫完都没匹配，说明不能获得
                if (!hit) {
                    System.out.println("不匹配");
                    return M;
                }
                // 此时hit = true. 若S1扫完时，S2都还没走到尾，说明也不能转换
                if (point1 == chs1.length - 1 && i < chs2.length - 1) {
                    System.out.println("S1扫完了" + i);
                    return M;
                }
                point1++;
            }
            // 到这里，S2 能够扫描完，说明S1可以获得S2，开始计算M
            // S1 [0, point1] 可以得到 S2
            M++;
        }
        return M;
    }
}