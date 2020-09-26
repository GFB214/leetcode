package 普通;

import java.util.Arrays;

class Solution26 {

    public static void main(String[] args) {
        int[] a = {1,1};
        int res = new Solution26().removeDuplicates(a);
        System.out.println(res + " " + Arrays.toString(a));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int index = 1;
        for (int i = 0; i < nums.length - 1 ; i++) {
            if (nums[i] != nums[i+1]){
                nums[index] = nums[i+1];
                index++;
            }
        }
        return index;
    }
}