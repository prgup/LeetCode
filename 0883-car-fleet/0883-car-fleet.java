class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Map <Integer, Integer> map = new HashMap<>();
        int n = position.length;
        for (int i=0; i<n; i++){
            map.put(position[i], speed[i]);
        }
        Integer [] li = Arrays.stream(position).boxed().toArray(Integer [] :: new);
        Arrays.sort(li, (a,b) -> b-a);
        double prev = Integer.MIN_VALUE;
        int ans=0;
        for (int i : li){
            int speedT = map.get(i);
            double time = (double)(target-i)/speedT;
            if (time > prev){
                ans++;
                prev = time;
            }
        }
        return ans;


        
    }
}