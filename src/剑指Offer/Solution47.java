package 剑指Offer;

class Solution47 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}