package 剑指Offer;

class Solution16 {

    public static void main(String[] args) {
        double myPow = new Solution16().myPow(2.00000, -2147483648);
        System.out.println(myPow);
    }
    public double myPow(double x, int n) {
        long tn = n;
        double res = 1;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (n < 0){
            x = 1/x;
            tn = -tn;
        }
        while (tn > 0){
            if ((tn & 1) == 1) {
                res *= x;
            }
            tn = tn>>>1;
            x *= x;
        }
        return res;
    }
}