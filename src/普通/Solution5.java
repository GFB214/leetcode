package 普通;

class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String ans = solution.longestPalindrome("aaaaa");
        System.out.println(ans);
    }

    public String longestPalindrome(String s){
        // return longestPalindrome1(s);
        return longestPalindrome2(s);
    }

    public String longestPalindrome1(String s) {
        if (s.length()<2) return s;
        char[] chars = s.toCharArray();
        int begin = 0, end = 0, max = 0, ansBegin = 0, ansEnd = 0;
        for (int i = 1; i < chars.length; i++) {

            for (int j = 0; j < 2; j++) {
                end = i;
                begin = i - j;
                if (chars[begin] != chars[end]) break;
                while (true){
                    if (begin - 1 < 0 || end + 1 >= chars.length) break;
                    if (chars[begin-1] == chars[end+1]){
                        begin--;
                        end++;
                    } else {
                        break;
                    }
                }
                if (end - begin + 1 > max){
                    max = end - begin + 1;
                    ansBegin = begin;
                    ansEnd = end;
                }
            }

        }
        return s.substring(ansBegin,ansEnd+1);
    }

    /**
     * dp
     * @param s
     * @return
     */
    public String longestPalindrome2(String s){
        if (s.length()<2) return s;
        char[] chars = s.toCharArray();
        int begin = 0, maxLen = 1;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            if (i != dp.length-1&&chars[i] == chars[i+1]){
                dp[i][i+1] = true;
                dp[i+1][i] = true;
            }
        }
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = dp[i+1][j-1]&&chars[i] == chars[j];
                if (dp[i][j] && j-i > maxLen) {
                    begin = i;
                    maxLen = j-i;
                }
            }
        }
        return s.substring(begin,begin+maxLen+1);
    }

}