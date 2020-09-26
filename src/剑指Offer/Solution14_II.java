package 剑指Offer;

class Solution14_II {
    public static void main(String[] args) {
        int res = new Solution14_II().cuttingRope(8);
        System.out.println(res);
    }
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        //可用快速幂模
        int mod = (int) (1e9+7);
        long res = 1;
        while (n > 4){
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res*n%mod);
    }
}