package 普通;

class Solution53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution53 solution = new Solution53();
        int maxSubArray3 = solution.maxSubArray3(nums);
        System.out.println(maxSubArray3);
    }

    public int maxSubArray(int[] nums) {
        // return maxSubArray1(nums);
        // return maxSubArray2(nums);
        return maxSubArray3(nums);
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int previousSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            previousSum = previousSum < 0? nums[i]:previousSum + nums[i];
            maxSum = Math.max(maxSum,previousSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1] ;
                maxSum = Math.max(nums[i],maxSum);
            }
        }
        return maxSum;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    private int maxSubArray3(int[] nums) {
        return maxSubArrayHelper(nums,0,nums.length-1);

    }

    private int maxSubArrayHelper(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftMax = maxSubArrayHelper(nums,left,mid);
        int rightMax = maxSubArrayHelper(nums,mid+1,right);
        int crossMax = findMaxCrossingSubarray(nums,left,mid,right);
        return Math.max(Math.max(leftMax,rightMax),crossMax);
    }

    private int findMaxCrossingSubarray(int[] nums, int left, int mid, int right) {
        int leftSum = -2147483647, sum = 0;
        for (int i = mid; i >= left; i--){
            sum += nums[i];
            leftSum = Math.max(leftSum,sum);
        }

        int rightSum = -2147483647;
        sum = 0;
        for (int i = mid + 1; i <= right; i++){
            sum += nums[i];
            rightSum = Math.max(rightSum,sum);
        }

        return leftSum+rightSum;
    }
}