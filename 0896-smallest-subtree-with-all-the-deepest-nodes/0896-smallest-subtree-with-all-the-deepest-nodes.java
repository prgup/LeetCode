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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        //count level //if lhs==rhs //retrun root

        return subTree(root); 
    }

    TreeNode subTree(TreeNode root){
        if (root==null)
        return root;
        int leftLevelCount = levelCount(root.left, 0);
        int rightLevelCount=levelCount(root.right, 0);
        if (leftLevelCount==rightLevelCount)
        return root;
        return (leftLevelCount>rightLevelCount)?subTree(root.left):subTree(root.right);

    }

    int levelCount(TreeNode root, int level){
        if (root==null)
        return level;
        return Math.max(levelCount(root.left, level+1), levelCount(root.right, level+1));

    }
}