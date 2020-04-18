package problem.easy.p204;

/**
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 */
public class Answer {
}

/**
 * @author caophoenix
 * @date 2019/08/14
 * time 83.37% .
 * mem . .
 *
 * Eratosthenes 筛选法
 */
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int i;
        boolean[] b = new boolean[n];
        i = 2;
        while (i * i < n) {
            if (!b[i]) {
                count++;
                int k = 2 * i;
                while (k < n) {
                    b[k] = true;
                    k += i;
                }
            }
            i++;
        }
        while (i < n) {
            if (!b[i])
                count++;
            i++;
        }
        return count;
    }
}

/**
 * 算法同上，代码更整洁
 */
class Solution_2 {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] booleans = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!booleans[i]){
                count++;
                for (int j = i; j < n; j=j+i) {
                    booleans[j] = true;
                }
            }
        }
        return count;
    }
}