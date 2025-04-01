class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]- b[0]));
        ArrayList <int [] > ans = new ArrayList<>();
        int left = intervals[0][0], right= intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            int l1= intervals[i][0], r1=intervals[i][1];
            if (right>=l1){
                right=Math.max(right, r1);
            }
            else {
                ans.add(new int[] {left, right});
                left = l1;
                right=r1;
            }

        }
        ans.add(new int[] {left, right});
        int ansF [][] = new int[ans.size()][2];
        for (int i=0; i<ans.size(); i++){
            ansF[i][0] = ans.get(i)[0];
            ansF[i][1] = ans.get(i)[1];
        }
        return ansF;
        // return new int[][] {{15,18},{8,10},{1,6}};
        
    }
}