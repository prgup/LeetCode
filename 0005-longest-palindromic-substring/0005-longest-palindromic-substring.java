class Solution {
    public String longestPalindrome(String s) {
        //expand around center
        int n = s.length();
        int ans=0;
        int left=0, right=0;
        for (int i=0; i<n-1;i++){
            int odd = getLength(s, i, i);
            if (odd>ans){
                left = i-odd/2;
                right = i+odd/2;
                ans =odd;
            }
            int even = getLength(s, i, i+1);
            if (even>ans){
                left = i-(even/2-1);
                right = i + (even/2-1)+1;
                ans =even;
            }
        }
        return s.substring(left, right+1);
        
    }
    int getLength(String s, int left, int right){
        int n = s.length();
        while (0<=left && right < n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
        
        return right-left-1;
    }
}