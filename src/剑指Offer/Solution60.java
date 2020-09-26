package 剑指Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution60 {

    public static void main(String[] args) {
        String ans = new Solution60().getPermutation(3, 2);
        System.out.println(ans);
    }

    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int div = 0, mod = 0;
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        for (int i = 1; i < n ; i++){
            long count = getCount(n - i);
            mod = (int) (k%count);
            if (mod == 0 ) {
                div = (int) (k/count - 1);
                mod = (int) count;
            } else {
                div = (int) (k/count);
            }
            ans.append(list.get(div));
            list.remove(div);
            k = mod;
        }
        ans.append(list.get(0));
        return ans.toString();
    }

    public static long getCount(int n){
        long res = 1;
        while(n > 0){
            res *= n;
            n--;
        }
        return res;
    }
}