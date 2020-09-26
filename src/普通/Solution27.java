package 普通;

import java.util.Arrays;

class Solution27 {

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        int res = new Solution27().removeElement(a,2);
        System.out.println(res + " " + Arrays.toString(a));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}