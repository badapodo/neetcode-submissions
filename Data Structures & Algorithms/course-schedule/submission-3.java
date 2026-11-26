class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
            inDegree[p[1]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.addLast(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.removeLast();

            for (int next : graph.get(curr)) {
                if (inDegree[next] == -1) {
                    continue;
                }
                inDegree[next]--;
                if (inDegree[next] != 0) {
                    continue;
                }
                inDegree[next]--;
                q.addLast(next);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != -1 && inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
