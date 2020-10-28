package 剑指Offer;

class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        int i = solution43.countDigitOne(1000000000);
        System.out.println(i);
    }

    public int countDigitOne(int n) {
        int unit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * unit;
            } else if (cur == 1) {
                res += high * unit + low + 1;
            } else {
                res += (high + 1) * unit ;
            }
            low += cur * unit;
            cur = high % 10;
            high /= 10;
            unit *= 10;
        }
        return res;
    }
}