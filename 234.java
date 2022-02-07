
// 234. Palindrome Linked List
    class Solution {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val);
        ref = ref.next;
        return ans && isEqual;
    }
}