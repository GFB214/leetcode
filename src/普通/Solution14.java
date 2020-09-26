package 普通;

/**
 * 最长公共前缀
 */
class Solution14 {

    public static void main(String[] args) {
        String[] strs = {"aac","aa","aac"};
        String result = new Solution14().longestCommonPrefix(strs);
        String result1 = new Solution14().longestCommonPrefix2(strs);
        String result2 = new Solution14().longestCommonPrefix3(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 0 ; i < strs.length; i++){
            while (strs[i].indexOf(result) != 0){
                result = result.substring(0,result.length()-1);
                if (result.length() == 0){
                    return "";
                }
            }
        }
        return result;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0 ; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 0; j<strs.length; j++){
                if(i==strs[j].length() || c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String tmp = "";
        for (int i = 1 ; i <= strs[0].length(); i++){
            tmp = strs[0].substring(0,i);
            for (int j = 1 ; j < strs.length; j++){
                if (strs[j].length()==tmp.length()-1||!strs[j].substring(0,i).equals(tmp)){
                    return tmp.substring(0,tmp.length()-1);
                }
            }
        }
        return tmp;
    }
}