class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int nCount = 0; 
        long ans=0;
        for (int [] li : matrix){
            for (int i : li){
                if (i<0)
                    nCount++;
                ans+=Math.abs(i);
                min = Math.min(Math.abs(i), min);
            }
        }
        if (nCount%2==0)
        return ans;
        return ans-2*min;


        
    }
}