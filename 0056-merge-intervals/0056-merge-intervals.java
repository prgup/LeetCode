class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) return new int[0][];
        
        // Sort intervals based on start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // (a, b) -> (a[0] - b[0]) (avoids integer overflow issues).
        ArrayList<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];//instead of storing two variable 
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }
        // Add the last merged interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
        //Since ArrayList<int[]> already holds references, the final int[][] output does not create extra space, just moves data.
        
    }
}