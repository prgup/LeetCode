class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int [] left = new int[n];
        int [] right = new int[n];
        left[0]= 0;
        right[n-1]=0;
        for (int i=1; i<n; i++){
            left[i]=Math.max(height[i-1], left[i-1]);
            right[n-1-i]= Math.max(height[n-i], right[n-i]);  
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int ans=0; 
        for (int i=0; i<n;i++){
            ans+=Math.max(Math.min(left[i],right[i])-height[i],0);
        }
        return ans;
        
    }
}