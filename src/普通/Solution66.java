package 普通;

import java.util.Arrays;

class Solution66 {
    public static void main(String[] args) {
        int[] a ={9};
        int[] ints = new Solution66().plusOne(a);
        System.out.println(Arrays.toString(ints));
    }
    public int[] plusOne(int[] digits) {
        int[] a = new int[digits.length + 1];
        digits[digits.length-1]++;
        if (digits[digits.length-1] != 10) return digits;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (digits[i] == 10){
                digits[i] = 0;
                digits[i-1] ++;
            }
        }
        if (digits[0] == 10){
            a[0] = 1;
            a[1] = 0;
            for (int i = 1; i < digits.length; i++) {
                a[i+1] = digits[i];
            }
            return a;
        }
        return digits;
    }
}