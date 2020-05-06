package org.example.leetcode;

import java.util.TreeSet;

public class P804摩斯密码 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println((new Solution()).uniqueMorseRepresentations(words));
    }

    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            TreeSet<String> set = new TreeSet<>();
            for (String word : words) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    res.append(codes[word.charAt(i) - 'a']);
                }
                set.add(res.toString());
            }
            return set.size();
        }
    }
}
