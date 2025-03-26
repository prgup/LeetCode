class Solution {
    public int minOperations(int[][] grid, int x) {
        int row=grid[0].length;
        int col=grid.length;
        int [] li = new int[row*col];
        int rem = grid[0][0]%x;
        int k=0;
        for (int i=0; i<col; i++){
            for (int j=0; j<row; j++){
                if (grid[i][j]%x != rem)
                return -1;
                li[k]=grid[i][j];
                k++;      
            }
        }
        Arrays.sort(li); //NLogN
        int median = li[row*col/2];
        int ans=0;
        for (int i=0; i<col; i++){
            for (int j=0; j<row; j++){
                ans += Math.abs(grid[i][j]-median )/x;   
            }
        }
        return ans;
        
        

    }
}