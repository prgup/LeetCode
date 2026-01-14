class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int x = points[0][0], y= points[0][1];
        int ans =0;
        for (int [] point: points){
            int xDiff = Math.abs(x - point[0]);
            int yDiff = Math.abs(y-point[1]);
            ans+= Math.max(xDiff, yDiff);
            x = point[0];
            y= point[1];
        }
        return ans;




        
    }
}