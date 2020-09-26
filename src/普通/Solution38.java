package 普通;

import java.util.Arrays;

class Solution38 {

    public static void main(String[] args) {
        String s = new Solution38().countAndSay(30);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String[] s = new String[n+1];
        Arrays.fill(s, "");
        s[1] = "1";
        for (int i = 2; i < s.length; i++) {
            char[] tmp = s[i-1].toCharArray();
            int count = 1;
            for (int i1 = 1; i1 < tmp.length; i1++) {
                if (tmp[i1] != tmp[i1-1]){
                    s[i] += count +"" + tmp[i1-1];
                    count = 1;
                } else {
                    count++;
                }
            }
            s[i] += count + "" +tmp[tmp.length-1];
        }
        return s[n];
    }
}