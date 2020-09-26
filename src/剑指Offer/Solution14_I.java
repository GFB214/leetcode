package 剑指Offer;

class Solution14_I {

    public static void main(String[] args) {
        Solution14_I solution14_i = new Solution14_I();
        int ans = solution14_i.cuttingRope(10);
        System.out.println(ans);
    }

    public int cuttingRope(int n) {
        int res = 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        while (n > 4){
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }
}