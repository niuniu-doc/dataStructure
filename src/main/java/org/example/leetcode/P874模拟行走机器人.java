package org.example.leetcode;

import java.util.HashSet;

public class P874模拟行走机器人 {
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(new Solution().robotSim(commands, obstacles));
    }
    static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {

            HashSet<String> set = new HashSet<>();
            /**
             * 第一次写时, set 定义时、逗号的后边加了空格,
             * 而后边contains判断时、没加空格, 导致判断不对、查了挺久
             */
//           for (int[] o : obstacles)
//                set.add(o[0] + "," + o[1]);

            for (int[] o : obstacles) {
                set.add(o[0] + ", " + o[1]);
            }
            int max = 0; int dir = 0; int x=0; int y=0;
            int[][] dirs ={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            for (int c : commands) {
                if (c == -2)
                    dir = dir == 0 ? 3 : dir - 1;
                else if (c == -1)
                    dir = dir == 3 ? 0 : dir + 1;
                else {
                    int[] xy = dirs[dir];
                    while (c-- > 0 && !set.contains((x + xy[0]) + ", " + (y + xy[1]))) {
                        x += xy[0]; y += xy[1];
                    }
                    max = Math.max(max, x * x + y * y);
                }
            }
            return max;
        }
    }
}
