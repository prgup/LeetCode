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
    private List<Integer> ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = new ArrayList<>(Arrays.asList(0));
        helperDFS(root );
        return ans.get(0);    

    }

    private int helperDFS(TreeNode root){
        if (root.left==null && root.right==null)
        return 1;
        int templeft=0, tempright=0;
        if (root.left!=null)
        templeft = helperDFS(root.left);
        if (root.right!=null)
        tempright = helperDFS(root.right);
        int ansT = Math.max(templeft+tempright, ans.get(0));
        ans.set(0, ansT);
        return Math.max(templeft, tempright)+1;


    }
    

    
}