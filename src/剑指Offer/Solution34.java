package 剑指Offer;


import java.util.ArrayList;
import java.util.List;

class Solution34 {

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root,0,sum);
        return res;
    }

    public void dfs(TreeNode node, int count, int sum){
        if (node == null || count + node.val > sum) return;
        list.add(node.val);
        if (count + node.val == sum && node.left==null && node.right==null) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            res.add(tmp);
        }
        dfs(node.left, count+node.val, sum);
        dfs(node.right, count+node.val, sum);
        if (list.size() > 0)list.remove(list.size()-1);
        return;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


