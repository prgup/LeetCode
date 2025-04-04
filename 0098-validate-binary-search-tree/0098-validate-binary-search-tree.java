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
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    boolean isValid(TreeNode root, long left, long right) {
        if (root == null)
            return true;
        if ((root.left != null && (root.left.val >= root.val || root.left.val <= left))
                || (root.right != null) && (root.right.val <= root.val || root.right.val >= right))
            return false;
        if (!isValid(root.left, left, root.val))
            return false;
        if (!isValid(root.right, root.val, right))
            return false;
        return true;

    }
}