class Solution {
    public boolean isNStraightHand(int[] hand, int group) {
        int n = hand.length;
        if (n%group !=0)
        return false;

        Arrays.sort(hand);
        boolean [] visited = new boolean [n];
        for(int i=0; i<n; i++){
            if (!visited[i]){
                visited[i]=true;
                int j=group-1, k=i+1, prev=i;
                while (j>0 ){
                    if (k>=n)
                        return false;

                    if (!visited[k] && prev!=k && hand[k]==(hand[prev]+1)){
                        visited[k]=true;
                        j--;
                        prev=k;
                    }
                    k++;
                }
            }
        }
        return true;
        
    }
}