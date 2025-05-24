class Trie {
    class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean wordEnd;
    public TrieNode () {
        this.children = new HashMap<>();
        this.wordEnd=false;
    }}

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp =root;
        
        for (char c : word.toCharArray()){
            temp.children.putIfAbsent(c, new TrieNode());
            temp = temp.children.get(c);

        }
        temp.wordEnd=true;
        
    }
    
    public boolean search(String word) {
        TrieNode temp =root;
        
        for (char c : word.toCharArray()){

            if (!temp.children.containsKey(c))
            return false;
            temp = temp.children.get(c);

        }
        return temp.wordEnd;
        
    }
    
    public boolean startsWith(String prefix) {
         TrieNode temp =root;
        
        for (char c : prefix.toCharArray()){

            if (!temp.children.containsKey(c))
            return false;
            temp = temp.children.get(c);

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