class Solution {
    public boolean canFinish(int numC, int[][] pre) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<pre.length; i++){
            int x = pre[i][0], y = pre[i][1];
            // List<Integer> li = graph.getOrDefault(y, new ArrayList<>());
            // li.add(x);
            // graph.put(y, li);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        int [] visited = new int[numC];
        for (int i=0; i<numC; i++){
            if (visited[i]==1)
            continue;
            boolean status = dfs(graph, visited, i);
            if (!status)
            return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int [] visited, int idx){
        System.out.println(idx);
        visited[idx]=2;
        for (int i : graph.getOrDefault(idx, new ArrayList<>())){
            if (visited[i]==2)
            return false;
            if (visited[i]!=1){
                boolean status = dfs(graph, visited, i);
                if (!status)
                return false;
            }
        }
        visited[idx]=1;
        return true;
    }
}