class Trie {

    class Node {
        Node [] children = new Node[26];
        boolean isEnd=false;
    }

    Node head;

    public Trie() {
        this.head = new Node();
    }
    
    public void insert(String word) {
        Node temp = this.head;//Set <Character, Node>
        for (char c : word.toCharArray()){
            int i = c-'a';
            if (temp.children[i]==null)
            temp.children[i]=new Node();
            temp = temp.children[i];
        }
        temp.isEnd = true;

        
    }
    
    public boolean search(String word) {
        Node temp= this.head;
        for (char c : word.toCharArray()){
            int i = c-'a';
            if (temp.children[i]==null)
            return false;
            temp=temp.children[i];
        }
        return temp.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        Node temp= this.head;
        for (char c : prefix.toCharArray()){
             int i = c-'a';
            if (temp.children[i]==null)
            return false;
            temp=temp.children[i];
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