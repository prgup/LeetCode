class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root = new TrieNode();

        private void addWord(String[] words) {
            for (String word : words) {
                TrieNode temp = root;
                for (char c : word.toCharArray()) {
                    if (temp.children[c - 'a'] == null)
                        temp.children[c - 'a'] = new TrieNode();
                    temp = temp.children[c - 'a'];
                }
                temp.word = word;
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n, List<String> ans, TrieNode trie) {
        char c = board[i][j];
        trie = trie.children[c - 'a'];
        if (trie.word != null) {
            ans.add(trie.word);
            trie.word = null;
        }
        board[i][j] = '#';

        for (int[] dir : new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }) {
            int i1 = i + dir[0], j1 = j + dir[1];

            if (0 <= i1 && m > i1 && 0 <= j1 && n > j1) {
                char c1 = board[i1][j1];
                if (c1 != '#' && trie.children[c1 - 'a'] != null) {
                    dfs(board, i1, j1, m, n, ans, trie);
                }

            }

        }
        board[i][j] = c;

    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();

        trie.addWord(words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (trie.root.children[c - 'a'] != null)
                    dfs(board, i, j, m, n, ans, trie.root);
            }
        }
        return ans;

    }

}