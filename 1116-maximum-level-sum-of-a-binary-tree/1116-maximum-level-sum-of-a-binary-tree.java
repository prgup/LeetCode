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
    public int maxLevelSum(TreeNode root) {

        int ans = 1;
        int sum = Integer.MIN_VALUE;
        Queue <TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level =1;
        while (!queue.isEmpty()) {
            int tempSum =0;
            int n = queue.size();
            for (int i=0; i<n; i++){
                TreeNode temp = queue.poll();
                tempSum+=temp.val;
                if (temp.left != null)
                queue.add(temp.left);
                if (temp.right !=null)
                queue.add(temp.right);
            }
            if (tempSum > sum){
                sum = tempSum;
                ans = level;
            }
            level++;

        }

        return ans;


        
    }
}