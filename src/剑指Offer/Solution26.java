package 剑指Offer;


class Solution26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        while (A != null){

        }
        return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public static boolean dfs(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left,B.left) && dfs(A.right,B.right);
    }

    public static boolean dfs2(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val){
            return dfs2(A.left,B.left) && dfs2(A.right,B.right);
        }
        return false;
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