package 剑指Offer;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;

class Solution44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        int digit = solution44.findNthDigit(100);
        System.out.println(digit);
    }

    public int findNthDigit(int n) {
        int level = 1;
        while (n > 0.9*pow(level,10)*level){
            n -= 0.9*pow(level,10)*level;
            level++;
        }
        int result = pow(level-1,10) + (n-1)/level;
        return String.valueOf(result).charAt((n-1)%level) - '0';
    }

    public int pow(int a, int b){
        int c = 1;
        while (a > 0){
            c *= b;
            a --;
        }
        return c;
    }
}