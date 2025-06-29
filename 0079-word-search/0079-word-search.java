class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n= board[0].length;
        boolean [][] visited = new boolean[m][n];
        for (int i=0; i< m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]==word.charAt(0)){
                    
                    visited[i][j]=true;
                    if (wordSearch(board,m,n, i, j, word, 1, visited))
                    return true;
                    visited[i][j]=false;
                }
            }
        }
        return false;  
    }

    boolean wordSearch(char [][] board, int m, int n, int i, int j, String word, int idx, boolean[][] visited){
        if (idx >= word.length())
        return true;
        
        for ( int [] dir : new int [][] {{-1,0}, {1,0}, {0,-1}, {0,1}}){
            int i1 = dir[0]+i, j1 = dir[1]+j;
            if (i1<0 || i1>=m || j1<0 || j1>=n)
            continue;
            if (!visited[i1][j1] && board[i1][j1]==word.charAt(idx)){ 
                visited[i1][j1]=true;
                if (wordSearch(board,m,n, i1, j1, word, idx +1, visited))
                return true;
                visited[i1][j1]=false;
            }
        }
        return false;
    }
}