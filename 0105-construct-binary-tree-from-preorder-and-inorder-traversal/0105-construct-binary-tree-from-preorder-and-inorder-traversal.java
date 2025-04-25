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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        building (root, preorder, inorder,0, n-1, 0);
        return root;
    }
    void building (TreeNode root, int[] preorder, int[] inorder, int il, int ir, int pl){
        if (ir <il || pl >= preorder.length)
        return;

        int head = preorder[pl];
        int mid=il;
        for (int i= il; i<=ir; i++){
            if (head==inorder[i]){
                mid =i;
                break;
            }
        }
        if (mid-il>0){
            root.left = new TreeNode (preorder[pl+1]);
            building (root.left, preorder, inorder, il , mid -1, pl+1) ;
        }
        if (ir-mid>0){
            root.right = new TreeNode (preorder[pl + mid-il + 1]);
            building (root.right, preorder, inorder, mid+1 ,ir, pl + mid-il + 1);
        }
        
    }
}