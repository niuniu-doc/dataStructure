package org.example.Stack;

import java.util.Stack;

public class P20括号匹配 {
    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("(){}[]{"));
        System.out.println((new Solution()).isValid("(){}[]{}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty())
                        return false;
                    char topChar = stack.pop();
                    if ((c == ')' && topChar != '(') || ((c == ']' && topChar != '[')) || (c == '}' && topChar != '{')) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
