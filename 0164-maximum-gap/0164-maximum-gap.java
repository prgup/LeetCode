class Solution {
    public int maximumGap(int[] nums) {
        bucketSort(nums);
        int ans=0, prev=nums[0]; 
        for (int i:nums){
            ans= Math.max(ans, i-prev);
            prev=i;
        }
        return ans;
    }
    public void bucketSort(int [] nums){
        int min=nums[0];
        int max = nums[0];
        for (int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int n = (int) Math.sqrt(nums.length);
        List<Integer> [] buckets = new List[n];
        for (int i=0; i<n;i++){
            buckets[i] = new ArrayList<>();
        }
        for (int i : nums){
            int idx = (i-min)/n;
            if (idx>=n)
            idx=n-1;
            if (idx<0)
            idx=0;
            buckets[idx].add(i);
        }
        int j=0;
        for (List<Integer> bucket : buckets){
            Collections.sort(bucket);
            for (int i: bucket){
                nums[j]=i;
                j++;
            }
        }

    }
}