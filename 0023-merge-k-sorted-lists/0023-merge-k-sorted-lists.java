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
        int n = lists.length;
        int j=n;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (j>0){
            int idx = -1, min=Integer.MAX_VALUE; 
            for (int i=0; i<n;i++){
                if (lists[i]!=null){
                if ( min> lists[i].val){
                    idx=i;
                    min=lists[i].val;
                }

                }}
            if (idx!=-1){
            ans.next = new ListNode(min);
            ans=ans.next;
            lists[idx]=lists[idx].next;
            if(lists[idx]==null)
            j--;
            }
            else
            j=0;
        }
     return head.next;   
    }
}