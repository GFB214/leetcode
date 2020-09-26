package 普通;

/**
 * Definition for singly-linked list.
 * public class 普通.ListNode {
 * int val;
 * 普通.ListNode next;
 * 普通.ListNode(int x) { val = x; }
 * }
 */
class Solution21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new Solution21().mergeTwoLists(l1, l2);
        l3.display();
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l3 = null , result;
        if (l1.val < l2.val){
            l3 = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            l3 = new ListNode(l2.val);
            l2 = l2.next;
        }
        result = l3;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 == null) l3.next = l2;
        if (l2 == null) l3.next = l1;
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void display(){
        ListNode l = this;
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}