class Solution {
    public int climbStairs(int n) {
        int [] climb = new int[n+1];
        climb[0]=1;
        for (int i=0; i<n; i++){
            climb[i+1]+=climb[i];
            if (i+2<=n)
            climb[i+2]+=climb[i];
        }
        return climb[n];
        
    }
}