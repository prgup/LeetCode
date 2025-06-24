class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left=0, right=n-1;
        int leftHeight=height[0], rightHeight=height[n-1];
        int ans=0;
        while (left<right){
            if (leftHeight>rightHeight){
                ans+=Math.max(rightHeight-height[right],0);
                right--;
                rightHeight=Math.max(rightHeight, height[right]);
            }
            else{
                ans+=Math.max(leftHeight-height[left],0);
                left++;
                leftHeight= Math.max(leftHeight, height[left]);
            }
        }
        return ans;


    }
}