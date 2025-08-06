class Solution {
    public int longestCommonSubsequence(String input1, String input2) {
        // String input1="0"+text1; //as they add O(n) tc and sc
        // String input2= "0"+text2;
        int len1 = input1.length(), len2 = input2.length();
        int [] dp = new int [len2+1];
        for (int i=1; i<len1+1; i++){ //i=0 represet empty text1;
        int prev = dp[0]; //store dp[i-1]j-1];
            for (int j=1; j<len2+1; j++){ //j=0 represent empty text2;
                int temp = dp[j]; 
                if (input1.charAt(i-1)==input2.charAt(j-1)){
                    dp[j]=1+prev;
                }
                else 
                    dp[j]= Math.max(dp[j], dp[j-1]);
                prev=temp;
            }
        }
        return dp[len2];
        
    }
}