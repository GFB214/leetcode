package 剑指Offer;

class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        int i = solution43.countDigitOne(1024000000);
        System.out.println(i);
    }
    public int countDigitOne(int n) {
        int div, mod, res = 0;
        for (int i = 1; i <= n; i++) {
            div = i;
            while (div != 0){
                mod = div%10;
                div /= 10;
                if (mod == 1) res++;
            }
        }
        return res;
    }
}