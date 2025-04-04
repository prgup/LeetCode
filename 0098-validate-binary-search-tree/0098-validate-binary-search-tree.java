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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    public boolean checkBST (TreeNode root, long min, long max){
        if (root==null)
            return true;
        boolean b1=true, b2=true;
        if (root.left!= null)
            b1 = (root.left.val<root.val &&root.left.val>min); 
        if (root.right !=null)
            b2 = (root.right.val> root.val && root.right.val <max);
        return (b1 && b2 && checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max));
        
        
    }
}