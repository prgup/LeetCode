class Solution {
    public int minimumIndex(List<Integer> nums) {
        //get the dominnant elelment
        int n= nums.size();
        Integer [] li = new Integer[n];
        int j=0;
        for (Integer i: nums){
            li[j] = i;
            j++;
        }
        Arrays.sort(li);
        int dom= li[n/2];
        //check if it's possible to make split 
        int count=0;
        for (Integer i: li){
            if (i==dom)
            count++;
        }
        if (count < (n/2 +1+n%2))
        return -1;
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