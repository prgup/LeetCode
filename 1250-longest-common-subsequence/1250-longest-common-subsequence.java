class Solution {
    int[][] memoization;

    public int longestCommonSubsequence(String text1, String text2) {
        memoization = new int[text1.length() ][text2.length()];
        Arrays.stream(memoization).forEach(a -> Arrays.fill(a, -1));
        helper(text1, text2, 0, 0);
        System.out.println(Arrays.deepToString(memoization));
        return memoization[0][0];
    }

    int helper(String text1, String text2, int len1, int len2) {
        if (text1.length() <= len1 || text2.length() <= len2)
            return 0;
        if (memoization[len1][len2]!=-1){
            return memoization[len1][len2];
        }
        if (text1.charAt(len1) == text2.charAt(len2)) {
            memoization[len1][len2] = 1+ helper(text1, text2, len1+1, len2+1);
            
        }
        else {
        memoization[len1][len2] =  Math.max(helper(text1, text2, len1+1, len2),
                helper(text1, text2, len1, len2+1));
        }
        return memoization[len1][len2];
        
    }
}