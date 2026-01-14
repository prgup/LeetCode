class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque <Integer> stack = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<n ; i++){
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.offer(i);
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int j = stack.pop();
                int temp = (i-j)*heights[j];
                ans = Math.max(temp, ans);
            }
        }
        int i = n;
        while (!stack.isEmpty() ){
                int j = stack.pop();
                int temp = (i-j)*heights[j];
                ans = Math.max(temp, ans);
            }


        return ans;
        
    }
}