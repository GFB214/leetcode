package 剑指Offer;

class Solution46 {

    int count;
    String[] chars;
    int[] dp;

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int ans = solution46.translateNum2(12258);
        System.out.println(ans);
    }

    public int translateNum(int num) {
        String num2Str = num + " ";
        chars = num2Str.split("");
        chars[chars.length - 1] = "";
        dfs(0);
        return count;
    }

    public void dfs(int index) {
        if (index >= chars.length - 1) {
            count++;
            return;
        }
        int num = Integer.parseInt(chars[index] + chars[index + 1]);
        dfs(index + 1);
        if (num >= 10 && num <= 25) dfs(index + 2);
    }

    public int translateNum2(int num){
        if (num < 10) return 1;
        String num2Str = num + "";
        char[] chars = num2Str.toCharArray();
        dp = new int[chars.length];
        dp[0] = 1;
        dp[1] = (chars[0] == '1') || (chars[0] == '2' && chars[1] < '6')?2:1;
        for (int i = 2; i < dp.length; i++) {
            if ((chars[i - 1] == '1') || (chars[i-1] == '2' && chars[i] < '6')){
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }

}