package problem.easy.p999;

/**
 * 999. 可以被一步捕获的棋子数
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 */
public class Answer {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numRookCaptures(char[][] board) {
        // board.length == board[i].length == 8
        int count = 0;
        int Ri = 0, Rj = 0;
        find_Rock:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    Ri = i;
                    Rj = j;
                    break find_Rock;
                }
            }
        }
        for (int i = Ri; i >= 0; i--) {
            if (board[i][Rj] == 'B') break;
            if (board[i][Rj] == 'p') {
                count++;
                break;
            }
        }
        for (int i = Ri; i < 8; i++) {
            if (board[i][Rj] == 'B') break;
            if (board[i][Rj] == 'p') {
                count++;
                break;
            }
        }
        for (int j = Rj; j >= 0; j--) {
            if (board[Ri][j] == 'B') break;
            if (board[Ri][j] == 'p') {
                count++;
                break;
            }
        }
        for (int j = Rj; j < 8; j++) {
            if (board[Ri][j] == 'B') break;
            if (board[Ri][j] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }
}