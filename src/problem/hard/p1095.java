package problem.hard;

/**
 * 1095. 山脉数组中查找目标值
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 */
public class p1095 {
}


interface MountainArray {
    public int get(int index);
    public int length();
}

/**
 * @author caoPhoenix
 * @date 2020/04/29
 *
 * 二分查找最佳实践
 * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int max = mountainArr.length() - 1;

        // 先二分找出peak
        int peak = findPeak(0, max, mountainArr);
        // System.out.println(peak);
        if (mountainArr.get(peak) < target) return -1;

        // 再从[0, peak]中找出target，找不到则[peak, max]中找
        int result = 0;
        result = lFindTarget(0, peak, target, mountainArr);
        // System.out.println(result);
        if (result != -1) return result;
        else return rFindTarget(peak, max, target, mountainArr);
    }

    public int findPeak(int left, int right, MountainArray mountainArr) {
        int max = right;
        while (left < right) {
            int middle = left + (right - left) / 2;

            int m_sub = middle == 0 ? -1 : mountainArr.get(middle - 1);
            int m_add = middle == max ? -1 : mountainArr.get(middle + 1);

            int m = mountainArr.get(middle);
            if (m > m_sub && m > m_add) {
                return middle;
            } else if (m_sub < m && m < m_add) {   // 上升
                left = middle + 1;
            } else if (m_sub > m && m > m_add) {    // 下降
                right = middle - 1;
            }
        }
        return left;
    }

    public int lFindTarget(int left, int right, int target, MountainArray mountainArr) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = mountainArr.get(middle);
            if (m == target) return middle;
            else if (m > target) {
                right = middle - 1;
            } else if (m < target) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int rFindTarget(int left, int right, int target, MountainArray mountainArr) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = mountainArr.get(middle);
            if (m == target) return middle;
            else if (m > target) {
                left = middle + 1;
            } else if (m < target) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
