class Trie {

    class Node {
        Map <Character, Node> set = new HashMap<>();
        boolean isEnd=false;
        // public Node (char c){
        //     this.set.put(c, null);
        // }
    }

    Node head;

    public Trie() {
        this.head = new Node();
        // head.put(0, new Node());
    }
    
    public void insert(String word) {
        Node temp = this.head;//Set <Character, Node>
        for (char c : word.toCharArray()){
            // if (temp == null ){
            //     temp.next= Node(c);
            // }
            // else 
            // if (!temp.contains(c)){
            //     temp.add(c);
            // }
            temp.set.putIfAbsent(c, new Node ());
            temp = temp.set.get(c);
        }
        temp.isEnd = true;

        
    }
    
    public boolean search(String word) {
        Node temp= this.head;
        for (char c : word.toCharArray()){
            if (!temp.set.containsKey(c))
            return false;
            temp=temp.set.get(c);
        }
        return temp.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        Node temp= this.head;
        for (char c : prefix.toCharArray()){
            if (!temp.set.containsKey(c))
            return false;
            temp=temp.set.get(c);
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */