class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (k==n || k==(n-1))
        return Math.max(1,k);
        int max=k;
        char [] li = s.toCharArray();
        for (int left=0; left<n; left++){
            int right=left+1, temp=k, current=1;
            while (right <n ){
                if (li[left]==li[right] || temp>0){
                    if (li[left]!=li[right])
                    temp--;
                right++;
                current++;
                }
                else
                break;
            }
            if (temp>0){
                current = Math.min(n, current+temp);
            }
            max = Math.max(max, current);
            if (max>n*0.8)
            break;

        }
        //  for (int right=n-1; right>0; right--){
        //     int left=right-1, temp=k, current=1;
        //     while (left >-1 ){
        //         if (li[left]==li[right] || temp>0){
        //             if (li[left]!=li[right])
        //             temp--;
        //         left--;
        //         current++;
        //         }
        //         else
        //         break;
        //     }
        //      if (temp>0){
        //         current = Math.min(n, current+temp);
        //     }
        //     max = Math.max(max, current);

        // }
        return max;
        
    }
}