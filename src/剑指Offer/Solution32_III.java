package 剑指Offer;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;


class Solution32_III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        //队列大小
        int size;
        while (!queue.isEmpty()){
            LinkedList<Integer> linkedList = new LinkedList<>();
            //注意如果for循环中的size不要用queue.size()替换，每次都会poll一个，size-1
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //从左往右
                if (res.size()%2==0) linkedList.addLast(poll.val);
                //从右往左
                else linkedList.addFirst(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(linkedList);
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