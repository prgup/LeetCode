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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
        return new ArrayList<>();
        
        ArrayDeque <TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (queue.size()!=0){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (n>0){
                TreeNode i = queue.pop();
                temp.add(i.val);
                if (i.left!=null)
                queue.add(i.left);
                if (i.right!=null)
                queue.add(i.right);
                n--;
            }
            ans.add(temp);
        }
        return ans;
        
    }
}