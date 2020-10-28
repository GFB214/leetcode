package 剑指Offer;

import java.util.Arrays;

class Solution56_I {

    public static void main(String[] args) {
        Solution56_I solution56_i = new Solution56_I();
        int[] ints = solution56_i.singleNumbers(new int[]{1, 2});
        System.out.println(Arrays.toString(ints));
    }
    public int[] singleNumbers(int[] nums) {
        int xor = nums[0], diff = 1;
        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
         while ((xor & diff) == 0){
             diff <<= 1;
         }
         int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((diff & nums[i]) != 0 ){
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a,b};
    }
}