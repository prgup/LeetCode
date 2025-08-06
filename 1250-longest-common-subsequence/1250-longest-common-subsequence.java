class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String input1="0"+text1;
        String input2= "0"+text2;
        int len1 = input1.length(), len2 = input2.length();
        int [][] dp = new int [len1][len2];
        for (int i=1; i<len1; i++){ //i=0 represet empty text1;
            for (int j=1; j<len2; j++){ //j=0 represent empty text2;
                if (input1.charAt(i)==input2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else 
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len1-1][len2-1];
        
    }
}