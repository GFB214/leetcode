package 剑指Offer;


import java.util.ArrayList;
import java.util.List;

class Solution36 {

    List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        Node ans = new Solution36().treeToDoublyList(n4);
        System.out.println(ans);
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);
        Node head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Node tmp = list.get(i);
            head.right = tmp;
            tmp.left = head;
            head = tmp;
        }
        list.get(0).left = list.get(list.size()-1);
        list.get(list.size()-1).right = list.get(0);
        return list.get(0);
    }

    public void dfs(Node node){
        if (node == null) return;
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }

   static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

