class Solution {
    
    public int uniquePaths(int m, int n) {
        int [][] memoization = new int[m+1][n+1];
        memoization[1][1]=1;
        return paths(m,n, memoization);
    }
    int paths (int m, int n, int [][] memoization){
        if (memoization[m][n] !=0)
        return memoization[m][n];
        if (m>1){
                paths(m-1,n, memoization);
            }
        if (n>1)
                paths(m,n-1, memoization);
        return memoization[m][n]=memoization[m-1][n]+memoization[m][n-1];

    }
}