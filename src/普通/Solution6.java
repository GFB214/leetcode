package 普通;

class Solution6 {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String ans = solution6.convert("PAYPALISHIRING", 4);
        System.out.println(ans);
    }

    public String convert(String s, int numRows) {
        return convert2(s,numRows);
    }

    private String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j+=cycleLen) {
                ans.append(chars[j+i]);
                if (i != 0 && i != numRows-1 && j+cycleLen-i<s.length() ){
                    ans.append(chars[j+cycleLen-i]);
                }
            }
        }
        return ans.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows < 2) return s;
        String ans = "";
        char[] sc = s.toCharArray();
        if (numRows == 2){
            for (int i = 0; i < sc.length; i++) {
                if (i%2==0) ans += sc[i];
            }
            for (int i = 0; i < sc.length; i++) {
                if (i%2==1) ans += sc[i];
            }
            return ans;
        }
        char[][] c = new char[numRows][s.length()];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = ' ';
            }
        }
        boolean flag = false; //false往下，true往上
        int row = 0, col = 0;
        for (int i = 0; i < sc.length; i++) {
            // System.out.println(row + " " + col + " " + flag);
            if (!flag){
                c[row++][col] = sc[i];
                if (row == numRows) {
                    flag = true;
                    row-=2;
                    col++;
                }
            } else {
                c[row--][col++] = sc[i];
                if (row == 0) flag = false;
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                ans += c[i][j];
            }
        }
        return ans.replace(" ","");
    }
}