class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque <Integer> stack = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n ; i++){
            if (stack.isEmpty() || heights[stack.peekLast()] <= heights[i]){
                // System.out.println(stack.peek());
                stack.offer(i);
                
                // System.out.println(stack.toString()+ " in");
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int j = stack.pollLast();
                int temp;
                if (stack.isEmpty()){
                    System.out.println(j + " "+ heights[j]);
                    temp = (j+1)*heights[j];
                }
                else
                    temp = (i-j)*heights[j];
                ans = Math.max(temp, ans);
            }
            stack.offer(i);
        }
        // System.out.println(stack.toString());
        int i = n;
        while (!stack.isEmpty() ){
                int j = stack.pollLast();
                int temp;
                if (stack.isEmpty()){
                    // System.out.println(j + " "+ heights[j]);
                    temp = n*heights[j];
                }
                else
                    temp = (i-stack.peekLast()-1)*heights[j];
                
                ans = Math.max(temp, ans);
            }



        return ans;
        
    }
}