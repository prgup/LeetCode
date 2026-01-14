class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque <Integer> stack = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // int min = 
        for (int i=0; i<n ; i++){
            min = Math.min(min, heights[i]);
            if (stack.isEmpty() || heights[stack.peekLast()] <= heights[i]){
                // System.out.println(stack.peek());
                stack.offer(i);
                
                // System.out.println(stack.toString()+ " in");
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int j = stack.pop();
                int temp = (i-j)*heights[j];
                // System.out.println(temp +" in");
                ans = Math.max(temp, ans);
            }
            stack.offer(i);
            // System.out.println(stack.toString());
        }
        int i = n;
        while (!stack.isEmpty() ){
                int j = stack.pop();
                int temp = (i-j)*heights[j];
                // System.out.println(temp);
                ans = Math.max(temp, ans);
            }

        ans= Math.max(ans, min*n);


        return ans;
        
    }
}