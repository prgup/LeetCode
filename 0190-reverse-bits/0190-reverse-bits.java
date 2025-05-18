public class Solution {
    public int reverseBits(int n) {
        int count =0;
        int ans=0;
        while ( count <32){
            ans<<=1;
            // if ((n&1)==1){
            //     ans+=1;
            // }
            ans|=(n&1);
            n>>>=1;
            count++;
        }
        return ans;
    }

}