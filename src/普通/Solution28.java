package 普通;

class Solution28 {
    public static void main(String[] args) {
        int i = new Solution28().strStr("hello", "ll");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack)||needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        char start = needle.charAt(0);
        char[] chars = haystack.toCharArray(), chars2 = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (start != chars[i]) {
                //找到第一个字母相同的下标
                while (i < chars.length && chars[i] != start) i++ ;
            }

            if (i <= chars.length - chars2.length){ // i下标最多可以到哪
                int j = i;
                for (int k = 0; k < chars2.length; k++){
                    if (chars2[k] == chars[j]) j++;
                }
                if (j == i + chars2.length) return i;
            }
        }
        return -1;
    }
}