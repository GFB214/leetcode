package 普通;

class Solution58 {

    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("a"));
    }
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int tail = chars.length-1, count = 0;
        while (tail >= 0 && chars[tail] == ' ') tail--;
        if (tail < 0) return 0;
        while (tail >= 0 && chars[tail--] != ' ') {
            count++;
        }
        return count;
    }
}