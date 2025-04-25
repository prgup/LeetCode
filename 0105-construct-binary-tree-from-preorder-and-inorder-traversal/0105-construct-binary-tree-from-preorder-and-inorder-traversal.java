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
        int n = preorder.length;
        if (n<=0)
        return null;
        TreeNode ans = new TreeNode (preorder[0]);
        int mid=0;
        for (int i=0; i<n; i++){
            if (preorder[0]==inorder[i]){
                mid =i;
                break;
            }
        }
        ans.left = buildTree (Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        ans.right = buildTree (Arrays.copyOfRange(preorder, mid+1, n), Arrays.copyOfRange(inorder, mid+1 , n));
        return ans;

        
    }
    
}