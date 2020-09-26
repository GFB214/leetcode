package 普通;

public class Solution3 {

    public static void main(String[] args) {
        int ans = new Solution3().lengthOfLongestSubstring("aab");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int[] tmp = new int[200];
        int ans = 0,index = 0,length = 0;
        while(index < c.length){
            char ch = c[index];
            if(tmp[ch]==0){
                tmp[ch] = 1;
                length++;
                index++;
            } else {
                if(ans<length){
                    ans = length;
                }
                tmp = new int[200];
                index -= (length-1);
                length = 0;
            }
        }
        if(ans<length){
            ans = length;
        }
        return ans;
    }
}
