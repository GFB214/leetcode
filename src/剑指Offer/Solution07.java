package 剑指Offer;



class Solution07 {

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6};
        int[] inorder = {4,2,5,1,3,6};
        TreeNode treeNode = new Solution07().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int xStart, int xEnd, int zStart, int zEnd){
        if (xStart > xEnd){
            return null;
        }
        if (zStart > zEnd) {
            return null;
        }
        int index = zStart;
        for (;index <= zEnd;index++){
            if (preorder[xStart] == inorder[index]){
                break;
            }
        }
        TreeNode treeNode = new TreeNode(preorder[xStart]);
        treeNode.left = buildTree(preorder,inorder,xStart+1,xStart+index-zStart,zStart,index-1);
        treeNode.right = buildTree(preorder,inorder,xStart+index-zStart+1,xEnd,index+1,zEnd);
        return treeNode;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
