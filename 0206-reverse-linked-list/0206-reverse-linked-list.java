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
    public ListNode reverseList(ListNode head) {
        if (head==null)
        return head;
        ListNode temp=head;
        ListNode prev=null;
        ListNode next=head;
        while (next !=null && next.next!=null){
            next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        temp.next=prev;
        return temp;
        
    }
}