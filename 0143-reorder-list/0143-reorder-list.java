/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }

        ListNode revNode = reverse(slow);
        ListNode fNode = head;
        ListNode revNode1=revNode;
        while (fNode!=null && fNode.next!= revNode && revNode1!=null){
            ListNode temp1=fNode.next;
            ListNode temp2=revNode1.next;
            fNode.next=revNode1;
            revNode1.next=temp1;
            fNode=temp1;
            revNode1=temp2;
        }
        if (fNode!=null)
        fNode.next=revNode1;
        return;


        
    }
    private ListNode reverse (ListNode root){
        if (root==null || root.next==null)
        return root;
        ListNode temp = reverse(root.next);
        root.next.next=root;
        root.next=null;
        return temp;

    }
}