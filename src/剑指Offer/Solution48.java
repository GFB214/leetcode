package 剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int ans = solution48.lengthOfLongestSubstring("");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0,tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            int j = map.getOrDefault(chars[i],-1);
            map.put(chars[i], i);
            if (tmp + j < i){
                tmp = tmp+1;
            } else {
                tmp = i-j;
            }
            res = Math.max(tmp,res);
        }
        return res;
    }
}