class Solution {
    public int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // int sum = Arrays.stream(nums).sum();
        // if ((target+sum)%2!=0)
        // return 0;
        // target = (target+sum)/2;
        map.put(0,1);
        int prefixSum = 0;
        int ans =0;
        int current = 0;
        for (int i : nums){
            prefixSum+=i;
            current = prefixSum-target;
            if (map.containsKey(current))
            ans+=map.get(current);
            map.put(prefixSum, map.getOrDefault(prefixSum,0) +1); 
        }
        return ans;
        
    }
}