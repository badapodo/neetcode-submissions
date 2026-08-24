class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] orders = new int[numCourses];
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            graph.get(pre).add(course);
            orders[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (orders[i] != 0) continue;
            queue.addLast(i);
        }

        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            ret.add(curr);
            for (int n : graph.get(curr)) {
                orders[n]--;
                if (orders[n] != 0) continue;
                queue.addLast(n);
            }
        }

        if (ret.size() != numCourses) return new int[]{};
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = ret.get(i);
        }
        return arr;
    }
}
