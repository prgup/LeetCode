class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left =0, right= n-1;
        int ans=0;
        while (left<right){
            int x = height[left];
            int y= height[right];
            int low=Math.min(x,y);
            ans = Math.max(low*(right-left), ans);
            if (x<y)
            left++;
            else
            right--;
        }
        return  ans;
        
    }
}