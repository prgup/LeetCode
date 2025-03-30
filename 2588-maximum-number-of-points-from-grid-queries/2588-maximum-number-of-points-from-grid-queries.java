class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int m = grid.length;
        int n= grid[0].length;
        Map <Integer, Integer> map= new HashMap<>();
        int [] li = new int[k];
        int x=0;
        li = Arrays.copyOf(queries,k);
        Arrays.sort(li);
        System.out.println(Arrays.toString(li));
        Queue <Integer []> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        queue.add(new Integer[] {grid[0][0], 0,0});
        count(grid, map, li, queue);
        x=0;
        for (int i : queries){
            li[x] = map.get(i);
            x++;
            
        }
        return li;

        
    }
    void count (int[][] grid, Map <Integer, Integer> map, int[] que, Queue <Integer[]> queue){

        int m=grid.length, n= grid[0].length, index=0, k = que.length;
        int ans=0;
        while (queue.size()>0){
            Integer [] temp = queue.poll();
            int a=temp[1];
            int b = temp[2];
            if (grid[a][b]==Integer.MAX_VALUE)
            continue;
            while ( index <k && que[index] <= grid[a][b])
            {
            map.put(que[index], ans);
            index++;
            }

            if (k<=index)
            return;

            ans++;
            map.put(que[index], ans);
            grid[a][b]= Integer.MAX_VALUE;
            
            if (0<a && grid[a-1][b]!=Integer.MAX_VALUE)
            queue.add(new Integer [] {grid[a-1][b], a-1, b});
            if (a<m-1 && grid[a+1][b]!=Integer.MAX_VALUE)
            queue.add(new Integer [] {grid[a+1][b], a+1, b});
            if (b<n-1 && grid[a][b+1]!=Integer.MAX_VALUE)
            queue.add(new Integer [] {grid[a][b+1], a, b+1});
            if (0<b && grid[a][b-1]!=Integer.MAX_VALUE)
            queue.add(new Integer [] {grid[a][b-1], a, b-1});
       

        } 

        for(int i=index; i<k;i++){
            map.put(que[i], ans);  
        }  
    }
}