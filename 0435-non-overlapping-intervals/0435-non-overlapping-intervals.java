class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int n = intervals.length;
        int ans=0, left=intervals[0][1];
        for (int i =1; i<n; i++){
            if (intervals[i][0] < left){
                ans++;
            }
            else 
            left=intervals[i][1];
        }
        return ans;
    }
}