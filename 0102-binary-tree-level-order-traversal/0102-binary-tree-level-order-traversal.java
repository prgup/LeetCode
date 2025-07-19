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
        List<List<Integer>> li = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size>0){
                TreeNode node = queue.remove();
                if (node.left!=null)
                queue.add(node.left);
                if (node.right!=null)
                queue.add(node.right);
                level.add(node.val);
                size--;
            }
            li.add(level);
        }
        return li;
    }
}