package 普通;

import java.util.Stack;

/**
 * 括号匹配 （栈问题）
 */
class Solution20 {

    public static void main(String[] args) {
        boolean valid = new Solution20().isValid("{[]}");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack.push(chars[i]);
                    break;
                case ')':
                    if (stack.lastElement() == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(chars[i]);
                    break;
                case ']':
                    if (stack.lastElement() == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(chars[i]);
                    break;
                case '}':
                    if (stack.lastElement() == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}