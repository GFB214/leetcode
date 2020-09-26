package 剑指Offer;

class Solution33 {

    public boolean verifyPostorder(int[] postorder) {
        // 最大的树
        return verify(postorder,0,postorder.length-1);

    }

    public boolean verify(int[] postorder, int start, int end){
        //没有左/右子树
        if (start >= end) return true;
        int p = start;
        //划分左子树
        while (postorder[p] < postorder[end]) p++;
        //记录左子树根节点
        int m = p-1;
        //划分右子树
        while (postorder[p] > postorder[end]) p++;
        //p==end表示每个节点都符合与根节点的大小关系
        //再递归校验左子树和右子树
        return p == end && verify(postorder,start,m) && verify(postorder,m+1,end-1);
    }
}