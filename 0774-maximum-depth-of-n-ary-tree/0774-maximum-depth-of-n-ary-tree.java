/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root==null)
        return 0;
        return depth(root);
        
    }
    public int depth(Node root){
        if (root.children==null || root.children.size()==0)
        return 1;
        int max=0;
        for (Node child : root.children){
            max = Math.max(max, depth(child));
        }
        return max+1;
    }
}