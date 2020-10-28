package 剑指Offer;

import java.util.Arrays;

class Solution45 {

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int[] nums = {3,30,34,5,9};
        String ans = solution45.minNumber(nums);
        System.out.println(ans);
    }

    public String minNumber(int[] nums) {
        String res = "";
        String[] nums2Str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2Str[i] = nums[i] + "";
        }
//        Arrays.sort(nums2Str);
        Arrays.sort(nums2Str, (s1,s2) -> (s1+s2).compareTo(s2+s1));
        for (int i = 0; i < nums2Str.length; i++) {
            res += nums2Str[i];
        }
        return res;
    }
}