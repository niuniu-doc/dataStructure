package org.example.leetcode.string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class LongestSubstring {
    /**
     * 查找不包含重复字符的最长子串
     * eg.
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "aswedsadc";
        s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
//        ReentrantLock
//        ThreadPoolExecutor
//        Executors.newScheduledThreadPool()
    }

    /**
     * 若字符串为空串, 最长重复子串为 0
     * 若字符串非空, 使用 滑动窗口, 遇到重复子串, 则移动start, 直到无重复子串,
     * 此时 max(end-start, max) 即为最长不重复子串;
     * 使用hashMap记录字符出现的位置, 可以快速定位上次该字符串出现的位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (StringUtils.isEmpty(s)) return 0;
        int strlen = s.length();
        if (strlen == 1) return 1;

        HashMap<Character, Integer> hashMap = new HashMap<>(strlen);
        int start=0, end=1, max=1;

        for (int i=1; i<strlen; i++) {
            Character c = s.charAt(i);
            if (!hashMap.containsKey(c)) {
                end++;
                max = Math.max(end-start, max);
            } else {
                start = hashMap.get(c);
            }
            hashMap.put(c, i);
        }
        return max;
    }
}
