package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution32_I {

    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[list.size()];
        int step = 0;
        for (Integer integer : list) {
            res[step++] = integer;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}