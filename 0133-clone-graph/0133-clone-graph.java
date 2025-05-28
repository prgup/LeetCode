/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null)
        return null;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        dfs(map, node);
        return map.get(node);
    }
    public void dfs(Map<Node, Node> map, Node node){
        for (Node i : node.neighbors){
            if (!map.containsKey(i)){
                map.put(i, new Node(i.val));
                dfs(map, i);
            }
            map.get(node).neighbors.add(map.get(i));
        }

    }
}