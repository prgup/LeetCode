class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt=n;
        for (int i=0; i<n; i++){
            //for odd string with i as middle
            cnt+=palidromeCheck(s, i-1, i+1);
            //for even string with i & i+1 as middle
            if ((i <n-1) && s.charAt(i)==s.charAt(i+1))
            cnt+= (1+palidromeCheck (s, i-1,i+2 ));
        }
        return cnt;
        
    }
    private int palidromeCheck (String s, int left, int right){
        int n = s.length();
        int ans=0;
        if (0>left || right>=n || left>=right)
        return ans;
        while (-1<left && right<n){
            if (s.charAt(left)!=s.charAt(right))
            return ans;
            left--;
            right++;
            ans++;
        }
        return ans;
    }
}