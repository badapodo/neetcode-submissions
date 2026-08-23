class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            inDegree[course]++;
            graph.get(pre).add(course);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) continue;
            queue.addLast(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            cnt++;

            for (int n : graph.get(curr)) {
                inDegree[n]--;

                if (inDegree[n] != 0) continue;
                queue.addLast(n);
            }
        }

        return cnt == numCourses;
    }
}
