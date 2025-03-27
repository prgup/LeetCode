class Solution {
    public int minimumIndex(List<Integer> nums) {
        //get the dominnant elelment//O(N)
        int n= nums.size();
        int dom=nums.get(0), cnt=0;
        for (Integer i: nums){
            if (i==dom)
            cnt++;
            else
            cnt--;
            if (cnt==0){
            dom=i;
            cnt++;
            }
        }
        //check if it's possible to make split 
        int count=0;
        for (Integer i: nums){
            if (i==dom)
            count++;
        }
        if (count < (n/2 +1+n%2))
        return -1;
        // making split
        int like=0, unlike=0, ans=0;
        for (Integer i: nums){
            if (i==dom)
            like++;
            else
            unlike++;
            if (like >unlike)
            break;
            ans++;
        }
        return ans;
        
    }

}