class WordDictionary {
    class Node {
        Node [] child;
        boolean isEnd;

        public Node (){
            child = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        int n = word.length();
        for (int i=0; i<n;i++){
            if (temp.child[word.charAt(i)-'a']==null)
            temp.child[word.charAt(i)-'a']= new Node();
            temp= temp.child[word.charAt(i)-'a'];
        }
        temp.isEnd=true;
        
    }
    public boolean search(String word, Node temp, int idx){
        for (int i=idx; i<word.length(); i++){
            if (word.charAt(i)=='.'){
                for (int j=0; j<26; j++){
                    if ((temp.child[j]!=null) && search(word, temp.child[j], i+1))
                    return true;
                }
                return false;
            }
            
            if (temp.child[word.charAt(i)-'a']==null)
                return false;
            temp= temp.child[word.charAt(i)-'a'];
        }
        return temp.isEnd;
    }
    
    public boolean search(String word) {
        return search(word, root, 0);
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */