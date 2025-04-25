/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
        return "";

        StringBuilder ans = new StringBuilder();
        Queue <TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        ans.append(root.val+",");
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left!=null)
            q.offer(temp.left);
            if (temp.right!=null)
            q.offer(temp.right);
            ans.append(temp.left!=null?temp.left.val+",":"N,");
            ans.append(temp.right!=null? temp.right.val+",": "N,");
        }
        return ans+"";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String[] ans = data.substring(0, data.length() - 1).split(",");
        return constructTree(ans);

    }

    TreeNode constructTree (String [] tree){
        TreeNode ans=new TreeNode (Integer.parseInt(tree[0]));
        Queue <TreeNode> q = new ArrayDeque<>();
        q.add(ans);
        int i=1;
        while (q.size()>0){
            TreeNode temp = q.poll();

            if (!tree[i].equals("N")){
                temp.left = new TreeNode(Integer.parseInt(tree[i]));
                q.offer(temp.left);
            }
            i++;
            if (!tree[i].equals("N")){
                temp.right = new TreeNode(Integer.parseInt(tree[i]));
                q.offer(temp.right);
            }
            i++;

        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));