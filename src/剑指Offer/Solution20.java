package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean number = solution20.isNumber(".3");
        System.out.println(number);
    }
    public boolean isNumber(String s) {
        char tmp;
        int p = 0;
        Map[] status = {
          new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
          new HashMap(){{put('d',2);put('.',4);}},
          new HashMap(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
          new HashMap(){{put('d',3);put('e',5);put(' ',8);}},
          new HashMap(){{put('d',3);}},
          new HashMap(){{put('s',6);put('d',7);}},
          new HashMap(){{put('d',7);}},
          new HashMap(){{put('d',7);put(' ',8);}},
          new HashMap(){{put(' ',8);}}
        };
        char[] chars = s.toLowerCase().replace(" ","").toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') tmp = 'd';
            else if (c == '+' || c == '-') tmp = 's';
            else if (c == '.' || c == 'e'||c == ' ') tmp = c;
            else tmp = ',';
            if (!status[p].containsKey(tmp)) return false;
            p = (int) status[p].get(tmp);
        }
        return p == 2||p == 3||p == 8|| p == 7;
    }
}