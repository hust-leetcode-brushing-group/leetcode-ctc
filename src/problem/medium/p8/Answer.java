package problem.medium.p8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Answer {
    public static void main(String[] args) {
        String str = "   +002147483649asv";
        System.out.println(new Solution().myAtoi(str));
    }
}

/**
 * if-else地狱
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        char[] chs = str.toCharArray();
        int result = 0;
        int signal = 1;
        boolean error = false;
        boolean isHead = true;
        for (int i = 0; i < chs.length; i++) {
            if (isHead) {
                if (chs[i] == ' ') continue; // 还没开始
                else if (chs[i] == '-') {
                    signal = -1;
                    isHead = false;
                } else if (chs[i] == '+') {
                    // signal = 1;
                    isHead = false;
                } else if (Character.isDigit(chs[i])) {
                    result = chs[i] - '0';
                    isHead = false;
                } else {    // 不是一个有效字符
                    error = true;
                    break;
                }
            } else {
                if (Character.isDigit(chs[i])) {
                    int end = chs[i] - '0';
                    if (result > Integer.MAX_VALUE / 10) {
                        result = signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        break;
                    } else if (result == Integer.MAX_VALUE / 10) {
                        if (signal == 1 && end >= 7) {
                            result = Integer.MAX_VALUE;
                            break;
                        } else if (signal == -1 && end >= 8) {
                            result = Integer.MIN_VALUE;
                            break;
                        }
                    }
                    result = result * 10 + end;
                } else {
                    break;
                }
            }
            // System.out.println("step " + chs[i] + ": " + result);
        }
        if (error) return 0;
        return result * signal;
    }
}

/**
 * 状态机
 */
class Solution_2 {
    private enum Status {start, signed, number, end}

    private int signal = 1;
    private int result = 0;

    public int myAtoi(String str) {
        Status status = Status.start;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            status = getNextStatus(status, chs[i]);
            // System.out.println(result);
            // 溢出 or 已计算得int极值
            if ((result == Integer.MAX_VALUE && signal == 1)
                    || (result == Integer.MIN_VALUE && signal == -1)) return result;
            if (status == Status.end)
                return signal * result;
        }
        if (status == Status.number) return signal * result;
        return 0;
    }

    private Status getNextStatus(Status status, char ch) {
        switch (status) {
            case start:
                if (ch == ' ') return Status.start;
                else if (ch == '+') return Status.signed;
                else if (ch == '-') {
                    signal = -1;
                    return Status.signed;
                } else if (Character.isDigit(ch)) {
                    result = result * 10 + ch - '0';
                    return Status.number;
                } else
                    return Status.end;
            case signed:
                if (Character.isDigit(ch)) {
                    result = result * 10 + ch - '0';
                    return Status.number;
                } else return Status.end;
            case number: // 从number到number才会溢出
                if (Character.isDigit(ch)) {
                    if (!willOverflow(ch - '0'))
                        result = result * 10 + ch - '0';
                    return Status.number;
                } else return Status.end;
        }
        return Status.end;
    }

    // 如果溢出就直接Max/Min了
    private boolean willOverflow(int end) {
        if (result > Integer.MAX_VALUE / 10) {
            result = signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            return true;
        } else if (result == Integer.MAX_VALUE / 10) {
            if (signal == 1 && end >= 7) {
                result = Integer.MAX_VALUE;
                return true;
            } else if (signal == -1 && end >= 8) {
                result = Integer.MIN_VALUE;
                return true;
            }
        }
        return false;
    }
}


/**
 * 正则表达式，并使用try-catch偷懒
 */
class Solution_3 {
    public int myAtoi(String str) {
        String regex = "([ ]*)([+-]?[0-9]+)([^0-9]*.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            String number = matcher.group(2);
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return number.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
//             return stringToInt(number);
        } else {
            return 0;
        }
    }

    // 以下是一段：考虑正负号、前置0、溢出 的 s2i 代码
    int sign = 1;
    int result = 0;
    private int stringToInt(String number) {
        char[] chs = number.toCharArray();
        int begin = 0;

        if (chs[0] == '-') {
            sign = -1;
            begin++;
        } else if (chs[0] == '+') begin++;
        while (begin < chs.length && chs[begin] == '0') begin++;

        for (int i = begin; i < chs.length; i++) {
            int end = chs[i] - '0';
            // 判断溢出
            if (willOverflow(chs[i] - '0')) {
                return result;
            } else {
                result = result * 10 + end;
            }
        }
        return sign * result;
    }

    private boolean willOverflow(int end) {
        if (result > Integer.MAX_VALUE / 10) {
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            return true;
        } else if (result == Integer.MAX_VALUE / 10) {
            if (sign == 1 && end >= 7) {
                result = Integer.MAX_VALUE;
                return true;
            } else if (sign == -1 && end >= 8) {
                result = Integer.MIN_VALUE;
                return true;
            }
        }
        return false;
    }
}