class Solution {
    public int minDistance(String word1, String word2) {
        int n1= word1.length(), n2 = word2.length();
        int [] dp = new int[n1+1];
        for (int i=n1; i>=0; i--){
            dp[i]=n1-i;
        }
        for (int i=n2-1; i>=0; i--){
            System.out.println(Arrays.toString(dp));
            int diag= dp[n1];
            dp[n1]++;
            
            
            for (int j=n1-1; j>=0; j--){
                if (word2.charAt(i)==word1.charAt(j)){
                    int temp=dp[j];
                    dp[j]=diag;
                    diag=temp;
                }
                else  {
                int temp= 1+ Math.min(dp[j+1], Math.min(dp[j], diag));
                diag=dp[j];
                dp[j]=temp;
                }

            }
            // dp[n1]++;
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
}