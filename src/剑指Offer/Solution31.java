package 剑指Offer;

import java.util.List;
import java.util.Stack;

class Solution31 {

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
//        int[] poped = new int[]{4,3,5,2,1};
        int[] poped = new int[]{4,3,5,1,2};
        Solution31 solution31 = new Solution31();
        boolean ans = solution31.validateStackSequences(pushed, poped);
        System.out.println(ans);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p1 = 0, p2 = 0;
        Stack<Integer> stack = new Stack<>();
        for (; p1 < pushed.length; p1++) {
            stack.push(pushed[p1]);
            while (!stack.empty() && stack.peek() == popped[p2]){
                stack.pop();
                p2++;
            }
        }
        return stack.empty();
    }
}