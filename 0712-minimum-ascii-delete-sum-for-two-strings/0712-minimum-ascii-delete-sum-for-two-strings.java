class Solution {
    private int [][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m = s2.length();
        dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        return count(s1, s2,dp,  0,0);


        
    }

    int count( String s1, String s2, int [][] dp, int idx1, int idx2){
        if (dp[idx1][idx2]!=-1)
        return dp[idx1][idx2];
        if (s1.length()<=idx1){
            int ans=0;
            for (int i=idx2; i<s2.length(); i++){
                ans+=s2.charAt(i);
            }
            dp[idx1][idx2]=ans;
            return ans;
        }
        if (s2.length() <= idx2){
            int ans=0;
            for (int i=idx1; i<s1.length(); i++){
                ans+=s1.charAt(i);
            }
            dp[idx1][idx2]=ans;
            return ans;

        }
        if (s1.charAt(idx1)==s2.charAt(idx2)){
            dp[idx1][idx2]= count(s1, s2,dp,  idx1+1, idx2+1);
            return dp[idx1][idx2];
        }
        dp[idx1][idx2] =  Math.min(count(s1,s2,dp, idx1+1, idx2) + s1.charAt(idx1), count(s1, s2,dp, idx1 ,idx2+1)+ s2.charAt(idx2));
        return dp[idx1][idx2];
    }
}