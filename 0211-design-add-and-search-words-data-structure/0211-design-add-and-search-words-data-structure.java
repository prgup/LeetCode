class WordDictionary {
    class TrieNode {
        TrieNode [] arr;
        boolean isEnd;

        public TrieNode (){
            arr = new TrieNode [26];
            isEnd=false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for (char i : word.toCharArray()){
            if (temp.arr[i-'a']==null)
                temp.arr[i-'a']= new TrieNode();
            temp=temp.arr[i-97];
        }
        temp.isEnd=true;
        
    }
    public boolean search(String word, TrieNode temp){
        int n = word.length();
        for (int i=0; i<n; i++){
            if (word.charAt(i)=='.'){
                for (int j=0;j<26; j++){
                    if (temp.arr[j]!=null && search(word.substring(i+1,n), temp.arr[j]))
                    return true; 
                }
                return false;
                // return search(word.substring(i+1,n), temp);
            }
            if (temp.arr[word.charAt(i)-'a']==null)
            return false;
            temp=temp.arr[word.charAt(i)-97];
        }
        return temp.isEnd;

    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        int n = word.length();
        return search(word, temp);
        // for (int i=0; i<n; i++){
        //     if (word.charAt(i)=='.'){
        //         return search(word.substring(i+1,n));
        //     }
        //     if (temp.arr[word.charAt(i)-'a']==null)
        //     return false;
        //     temp=temp.arr[word.charAt(i)-'a'];
        // }
        // return temp.isEnd;
        
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */