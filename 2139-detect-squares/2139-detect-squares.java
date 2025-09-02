class DetectSquares {

    private final Map<Integer, Map<Integer, Integer>> countMap;
    public DetectSquares() {
        this.countMap = new HashMap<>();
        
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        // Map<Integer, Integer> temp = countMap.getOrDefault(x, new HashMap<>());
        // temp.put(y, temp.getOrDefault(y,0)+1);
        // countMap.put(x, temp);
        countMap.putIfAbsent(x, new HashMap<>());
        countMap.get(x).put(y, countMap.get(x).getOrDefault(y, 0) + 1);

    }
    
    public int count(int[] point) {
        if (!countMap.containsKey(point[0]))
        return 0;
        int ans=0;
        int x=point[0], y=point[1];
        for (int i : countMap.keySet()){
            if ( i != x && countMap.get(i).containsKey(y)){
                int length = Math.abs(i-x);
                //square above this point //both left and right
                ans += countMap.get(x).getOrDefault(y+length,0)*
                        countMap.get(i).get(y)*
                        countMap.get(i).getOrDefault(y+length,0);
                //square below this point // both left and right        
                ans += countMap.get(x).getOrDefault(y-length,0)*
                        countMap.get(i).get(y)*
                        countMap.get(i).getOrDefault(y-length,0);


            }
        }
        return ans;
        
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */