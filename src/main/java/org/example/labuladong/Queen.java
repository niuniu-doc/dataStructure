package org.example.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Queen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution2().solveNQueens(n));
    }

    static class Solution2{
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            if (n == 0) return null; // 特判
            // 初始化棋盘, 用 . 填充
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtrack(board, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            // terminate
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }

            int cols = board[0].length;
            for (int col=0; col < cols; col++) {
                if (!isValid(board, row, col)) continue; // 非法条件判断

                board[row][col] = 'Q'; // 做选择
                backtrack(board, row+1); // 回溯
                board[row][col] = '.'; // 撤销选择
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            // check col
            for (char[] chars : board)
                if (chars[col] == 'Q') return false;

            // check upleft
            for (int i=row-1,j=col-1; i>=0&&j>=0; i--,j--)
                if (board[i][j] == 'Q') return false;

            // check upright
            int cols = board[0].length;
            for (int i=row-1,j=col+1; i>=0&&j<cols; i--, j++)
                if (board[i][j] == 'Q') return false;

            return true;
        }

        private List<String> charToString(char[][] board) {
            List<String> res = new LinkedList<>();
            for (char[] chars : board) {
                res.add(String.valueOf(chars));
            }
            return res;
        }
    }
}
