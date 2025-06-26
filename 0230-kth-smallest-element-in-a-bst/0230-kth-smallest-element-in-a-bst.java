/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=1;
    int result=0;
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    void inOrder(TreeNode root, int k){
        if (root==null || count  > k) return;
        
        inOrder(root.left, k);
        if (count == k){
            result =  root.val;
        }
        count++;
        inOrder(root.right, k);
    }
}