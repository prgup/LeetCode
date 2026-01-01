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

    private int head=0;
    private Map<Integer, Integer> inOrderIndex= new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx=0;
        for (int i : inorder){
            inOrderIndex.put(i, idx);
            idx++;
        }
        return constructTree(preorder, 0, idx-1);

        
    }

    private TreeNode constructTree(int [] preorder, int inLeft, int inRight){
        if ( inRight < inLeft)
        return null;

        TreeNode root = new TreeNode(preorder[head]);
        int mid = inOrderIndex.get(preorder[head]);
        head++;
        
        root.left = constructTree(preorder, inLeft, mid-1);
        root.right = constructTree(preorder, mid+1, inRight);
        return root;
    }
}