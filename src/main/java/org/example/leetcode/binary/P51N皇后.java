package org.example.leetcode.binary;

import java.util.*;

public class P51N皇后 {
     static class Solution {
        List<List<String>> res = new LinkedList<>();
        public List<List<String>> solveNQueens(int n) {
            /**
             * 决策树的每一层表示棋盘上的每一行, 每个节点可以做出的选择是:
             * 该行的任意一列放置一个皇后
             */
            /**
             * 方法一: 回溯
             * 回溯其实就是一个决策树的遍历过程
             * 1. 路径: 已经做出的选择
             * 2. 选择列表: 当前可以做出的选择
             * 3. 结束条件: 到达决策树底层, 无法再做出选择的条件
             * 框架:
             * res = []
             * def backtrack(路径, 选择列表)
             *   if 满足结束条件
             *      res.add(路径)
             *      return
             *
             *   for 选择 in 选择列表
             *      做选择
             *      backtrack(路径, 选择列表)
             *      撤销选择
             */
            if (n <= 0) return null;
            char[][] board = new char[n][n];
            for (char[] chars : board) Arrays.fill(chars, '.');
            backtrack(board, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            /**
             * 路径: board 中小于 row的那些行都已经成功放置了皇后
             * 可选择列表: 第row行中所有列都是放置Q的选择
             * 结束条件: row超过board的最后一行
             */
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) continue;
                board[row][col] = 'Q';
                backtrack(board, row+1);
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            for (char[] chars : board) {
                if (chars[col] == 'Q') return false; // 检查列
            }
            for (int i = row-1, j=col-1; i>=0&&j>=0; i--, j--) {
                if (board[i][j] == 'Q') return false; // 检查左上
            }
            for (int i=row-1, j=col+1; i>=0&&j<rows; i--, j++) {
                if (board[i][j] == 'Q') return false; // 检查右上
            }
            return true;
        }

        private  List<String> charToString(char[][] array) {
            List<String> res = new LinkedList<>();
            for (char[] chars : array) {
                res.add(String.valueOf(chars));
            }
            return res;
        }
    }

    static class Solution2 {
        /**
         * DFS
         */
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.'); // 初始化棋盘
            }
            List<List<String>> res = new ArrayList<>();
            dfs(board, 0, res);
            return res;
        }

        private void dfs(char[][] board, int colIndex, List<List<String>> res) {
            if (colIndex == board.length) {
                res.add(charToString(board));
                return;
            }
            for (int i=0; i<board.length; i++) {
                if (validate(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    dfs(board, colIndex+1, res);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean validate(char[][] board, int x, int y) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < y; j++) {
                    if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                        return false;
                }
            }

            return true;
        }

        private  List<String> charToString(char[][] array) {
            List<String> res = new LinkedList<String>();
            for(int i = 0; i < array.length; i++) {
                String s = new String(array[i]);
                res.add(s);
            }
            return res;
        }
    }

    static class Solution3 {
        /**
         * 位运算解法
         */
        private int size;
        private int count;

        private void solve(int row, int ld, int rd) {
            if (row == size) {
                count++;
                return ;
            }
            int pos = size & (~(row | ld | rd));
            while (pos != 0) {
                int p = pos & (-pos);
                pos -= pos;
                solve(row|p, (ld|p)<<1, (rd|p)>>1);
            }
        }

        public int totalNQueens(int n) {
            count = 0;
            size = (1<<n)-1;
            solve(0, 0, 0);
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().solveNQueens(n));
        System.out.println(new Solution2().solveNQueens(n));
        System.out.println(new Solution3().totalNQueens(n));
    }
}
