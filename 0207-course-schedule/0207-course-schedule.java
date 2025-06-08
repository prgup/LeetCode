class Solution {
    // A topological sort is a linear ordering of vertices in a directed acyclic graph (DAG).  
    // a topological sort algorithm returns a sequence of vertices in which the vertices never come before their predecessors on any paths
    public boolean canFinish(int numC, int[][] pre) {
        int [] inDegree = new int[numC];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for ( int [] edge : pre){ //O(V+E)
            int in = edge[1]; 
            int out = edge[0];
            graph.computeIfAbsent(out, k->new ArrayList<>()).add(in);
            inDegree[in]++;
        }
        Queue <Integer> queue = new ArrayDeque<>();

        for (int i=0; i<numC; i++){ //O(V)
            if (inDegree[i]==0) queue.offer(i);
        }
        int idx=0;
        while (!queue.isEmpty()){ //O(V+E)
            int current = queue.poll();
            for (int i : graph.getOrDefault(current, new ArrayList<>())){
                inDegree[i]--;
                if (inDegree[i]==0)
                queue.offer(i);
            }
            idx++;
        }

        return idx==numC;


        
    }
}