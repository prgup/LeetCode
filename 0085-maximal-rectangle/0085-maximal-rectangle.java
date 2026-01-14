class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];

        for (int j = 0; j < n; j++) {
            int rowMaxArea = 0;
            ArrayDeque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                heights[i] = (matrix[j][i] == '1') ? heights[i] + 1 : 0;
            }

            for (int i = 0; i <= m; i++) {
                int height = (i == m) ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] > height) {
                    int h = heights[stack.pop()];
                    int right = i;
                    int left = (stack.isEmpty()) ? -1 : stack.peek();
                    int width = right - left - 1;
                    rowMaxArea = Math.max(rowMaxArea, width * h);
                }
                stack.push(i);
            }
            maxArea = Math.max(rowMaxArea, maxArea);
        }

        return maxArea;

    }
}