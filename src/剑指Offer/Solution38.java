package 剑指Offer;

import java.util.*;

class Solution38 {

    List<String> ans = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }

    void dfs(int index){
        //长度够了添加结果
        if (index == chars.length - 1){
            ans.add(new String(chars)) ;
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            //当前位置已出现过该字母，跳过
            if (set.contains(chars[i])) continue;
            //记录统计过的字母
            set.add(chars[i]);
            //交换位置
            swap(index,i);
            //dfs下一个位置
            dfs(index+1);
            //记得换回来
            swap(index,i);
        }
    }

    void swap(int x, int y){
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

    String[] bfs(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        //记录每个字母出现的次数
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) map.put(chars[i],map.get(chars[i])+1);
            else map.put(chars[i],1);
        }
        //无重复字母集合
        Set<Character> characters = map.keySet();
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        listA.add("");
        //字符串长度为n，要加n次
        for (int i = 0; i < chars.length; i++) {
            //要添加的字母
            for (Character character : characters) {
                //待添加的字符串集合
                for (String t : listA) {
                    //统计要添加字母在当前字符串出现的次数，若小于s中出现次数，则加到尾部并将字符串加到集合中
                    int count = 0;
                    for (int j = 0; j < t.length(); j++) {
                        if (character == t.charAt(j)) count++;
                    }
                    if (count < map.get(character)) listB.add(t + character);
                }
            }
            //上一次循环的结果是下一次的输入
            listA.clear();
            listA.addAll(listB);
            listB.clear();
        }
        return listA.toArray(new String[0]);
    }
}