class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int n = intervals.length;
        int [] overlap = new int[n];
        int max=0;
        for (int i =0; i<n; i++){
            if (overlap[i]==0){
            for (int j=i+1; j<n; j++){
                if ( intervals[j][0] < intervals[i][1]){
                    overlap[j]++;
                }
            }
        }
        }
        int ans=0;
        for (int i: overlap){
            if (i!=0)
            ans++;
            
        }
        return ans;

        
    }
}