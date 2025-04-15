class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int [] li = Arrays.copyOf(nums, n);//n//n
        Arrays.sort(li);//nlongn
        List <List<Integer>> temp = new ArrayList<>();//n
        for (int i=0; i<n-2; i++){
            int cur = li[i];
            if (i >0 && li[i]==li[i-1])
            continue;
            if (cur>0)
            break;
            int left = i+1, right = n-1;
            while (left<right){
                if ((cur + li[left]+li[right]) > 0)
                right--;
                else if ((cur + li[left]+li[right]) < 0)
                left++;
                else {
                    List<Integer> t = new ArrayList<>();
                    t.add(cur);
                    t.add(li[left]);
                    t.add(li[right]);
                    temp.add(t);
                    while (left < right && li[left] ==li[left+1]){
                    left++;
                    }
                    while (left < right && li[right]==li[right-1]){
                        right--;
                    }
                    left++; 
                    right--;
                }
            }
        }
        return temp;
        // List <List<Integer>> ans = new ArrayList<>();
        // for (List<Integer> li1: temp){
        //     List<Integer> ans1 = new ArrayList<>();
        //     for (int i : li1){
        //         for (int j=0; j<n; j++){
        //             if (i==nums[j] && !ans1.contains(j)){
        //             ans1.add(j);
        //             break;
        //             }
        //         }

        //     }
        //     ans.add(ans1);
        // }

        // return ans;
    }
}