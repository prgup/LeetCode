class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue < int []> main = new ArrayDeque<>();
        Queue <int []> neighbor = new ArrayDeque<>();
        boolean [][] visited = new boolean [m][n];
        int [][] value = new int[m][n];
        for (int [] i: value) Arrays.fill(i, Integer.MAX_VALUE);
        int [][] movement = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        main.offer(new int[] {0,0});
        value[0][0]=0;
        while (!visited[m-1][n-1]){
            while (!main.isEmpty()){
                int [] current = main.poll();
                int x=current[0], y=current[1];
                if (visited[x][y])
                continue;
                else
                visited[x][y]=true;
                int instruction = grid[x][y];
                int [] next = movement[instruction-1];
                int x1= next[0]+x, y1 = next[1]+y;
                if (0<=x1 && x1<m && 0<=y1 && y1<n && !visited[x1][y1]){
                    main.offer(new int[] {x1, y1});
                    // visited[x1][y1]=true;
                    value[x1][y1]=Math.min(value[x][y], value[x1][y1]);
                }
                for (int [] li : movement){
                    int x2= li[0]+x, y2 = li[1]+y;
                    if (0<=x2 && x2<m && 0<=y2 && y2<n && !visited[x2][y2] && !(x1==x2 && y1==y2) ){
                    neighbor.offer(new int[] {x2, y2});
                    value[x2][y2]=Math.min(value[x][y]+1, value[x2][y2]);
                }}
            }
                Queue <int []> temp = neighbor;
                neighbor = main;
                main=temp;
                
            }

            return value[m-1][n-1];

        
        
    }
}