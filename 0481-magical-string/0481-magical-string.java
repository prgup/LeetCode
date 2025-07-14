class Solution {
    public int magicalString(int n) {
        int [] li = new int[n+2];
        li[0]=1; li[1]=2; li[2]=2;
        int ans=1;
        int idxD=3, idxR=3;
        for (idxR=3; idxR<n; idxR++){
            int digit = 3-li[idxD-1];
            int repeat = li[idxR-1];
            while (repeat>0){
                li[idxD]=digit;
                idxD++;
                repeat--;
                if (digit==1)
                ans++;
                if (idxD>=n)
                return ans;
            }
        }
        return ans;
        
    }
}