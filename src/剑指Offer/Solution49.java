package 剑指Offer;

class Solution49 {

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        int res = solution49.nthUglyNumber(1690);
        System.out.println(res);
    }
    public int nthUglyNumber(int n) {
        int x2 = 1, x3 = 1, x5 = 1, m2, m3, dp5;
        int[] dp = new int[1700];
        dp[1] = 1;
        for (int i = 2; i <= n ; i++){
            m2 = dp[x2] * 2;
            m3 = dp[x3] * 3;
            dp5 = dp[x5] * 5;
            dp[i] = Math.min(m2,Math.min(m3,dp5));
            if (dp[i] == m2) x2++;
            if (dp[i] == m3) x3++;
            if (dp[i] == dp5) x5++;
        }
        return dp[n];
    }
}