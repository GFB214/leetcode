package 普通;

class Solution35 {


    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) break;
        }
        if (i == nums.length-1 && target > nums[i]){
            return i+1;
        } else {
            return i;
        }
    }
}