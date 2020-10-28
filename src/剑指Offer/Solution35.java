package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

class Solution35 {

    public Node copyRandomList(Node head) {
        //空
        if (head == null) return head;
        Node cur = head;
        //利用HashMap将原节点和复制节点一一对应起来
        Map<Node,Node> map = new HashMap<>();
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random =  map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        //空
        if (head == null) return head;
        //在每个节点后面复制一个节点插入,此处要注意null只有一个
        //1 -> 2 -> 3 -> null
        //1 -> 1 -> -> 2 -> 2 -> 3 -> 3-> null
        Node cur = head;
         while (cur != null){
             Node tmp = new Node(cur.val);
             tmp.next = cur.next;
             cur.next = tmp;
             cur = cur.next.next;
         }

         //复制random
         cur = head;
         while (cur != null){
             if (cur.random != null){
                 //关键
                 cur.next.random = cur.random.next;
             }
             cur = cur.next.next;
         }

         //将链表一分为二
         Node copyHead = head.next, copyNode = head.next;
         cur = head;
         while (cur != null){
             //注意 一 和 二 的顺序
             //一
             cur.next = cur.next.next;
             cur = cur.next;
             //二
             if (copyNode.next != null){
                 copyNode.next = copyNode.next.next;
                 copyNode = copyNode.next;
             }
         }

         return copyHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

