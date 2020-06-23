package problem.easy.p67;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/23
 * time 3 ms
 * mem 38.6 MB
 * 力扣服务器判题慢，导致超时了一次，离谱
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        a = sb.reverse().toString();
        sb.delete(0, sb.length());
        b = sb.append(b).reverse().toString();
        sb.delete(0, sb.length());
        int length = Integer.max(a.length(), b.length());
        int a_ = 0, b_ = 0, c_ = 0;
        for (int i = 0; i < length; i++) {
            a_ = i < a.length() ? a.charAt(i) - '0' : 0;
            b_ = i < b.length() ? b.charAt(i) - '0' : 0;
            sb.append((a_ + b_ + c_) % 2);
            c_ = (a_ + b_ + c_) / 2;
        }
        if (c_ == 1) sb.append(1);
        return sb.reverse().toString();
    }
}