class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0; 
        for (int i=0; i<n; i++){
            //for substring with i as middle
            int left =i;
            int right = i;
            while  (-1<left && n>right){
                if (s.charAt(left)!=s.charAt(right))
                break;
                ans++;
                left--;
                right++;
            }
             //for substring with i and i+1 as middle
            left =i;
            right = i+1;
            while  (-1<left && n>right){
                if (s.charAt(left)!=s.charAt(right))
                break;
                ans++;
                left--;
                right++;
            }
        }
        return ans;


        
    }
}