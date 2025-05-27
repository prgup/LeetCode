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

        HashMap<Node, Node> map = new HashMap<>();
        Queue <Node> queue = new ArrayDeque<>();

        queue.add(node);
        map.put(node,new Node(node.val) );

        while (queue.size()> 0){
            Node temp = queue.poll();
            for (Node i: temp.neighbors){
                 if (!map.containsKey(i)){
                    map.put(i,new Node(i.val));
                    queue.add(i);
                 }
                map.get(temp).neighbors.add(map.get(i));

            }
        }

        return map.get(node);


        
    }
}