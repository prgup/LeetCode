class Solution {
    public int[] findOrder(int numC, int[][] pre) {
        int[] inDegree = new int[numC];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : pre) { //O(V+E)
            int out = edge[1];
            int in = edge[0];
            graph.computeIfAbsent(out, k -> new ArrayList<>()).add(in);
            inDegree[in]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numC; i++) { //O(V)
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int idx = 0;
        int[] topologicalSort = new int[numC];
        while (!queue.isEmpty()) { //O(V+E)
            int current = queue.poll();
            topologicalSort[idx] = current;
            idx++;
            for (int i : graph.getOrDefault(current, new ArrayList<>())) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.offer(i);
            }
        }

        return (idx==numC)?topologicalSort:new int[] {};

    }
}