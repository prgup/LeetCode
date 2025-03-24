class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] li = new int[n];
        Arrays.fill(li, -1);
        for (int i=0; i<n; i++){
            for (int j=1; j<=nums[i]& (j+i<n) ; j++){
                if (li[i+j]==-1)
                li[i+j]=i;
            }
        }
        int ans=0;
        int i=n-1;
        while (i>0){
            i = li[i];
            ans++;
        }
        System.out.println(Arrays.toString(li));
        return ans;
    }
}