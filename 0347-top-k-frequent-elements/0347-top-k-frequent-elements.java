class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        if (k==n)
        return nums;
        Map <Integer, Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        Queue <Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a)- map.get(b));
        int [] ans = new int[k];
        for (int i : map.keySet()){
            minHeap.offer(i);
            if (minHeap.size()>k)
            minHeap.poll();

        }
        for (int i=0; i<k; i++){
            ans[i]=minHeap.poll();
        }
        return ans;

        
    }
}