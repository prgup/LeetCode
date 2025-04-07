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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        Queue <ListNode> queue = new PriorityQueue <> ((a,b) ->  a.val-b.val);
        for (ListNode node : lists){
            if (node!=null)
            queue.offer(node);
        }
        while (queue.size()>0){
            ans.next = queue.poll();
            if (ans.next.next!=null)
            queue.offer(ans.next.next);
            ans = ans.next;
        }
        return head.next;
    }
}