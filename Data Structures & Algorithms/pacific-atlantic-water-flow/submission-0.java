class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int h = heights.length;
        int w = heights[0].length;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Deque<int[]> pQueue = new ArrayDeque<>();
        Deque<int[]> aQueue = new ArrayDeque<>();

        boolean[][] pVisited = new boolean[h][w];
        boolean[][] aVisited = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            pQueue.addLast(new int[]{y, 0});
            pVisited[y][0] = true;

            aQueue.addLast(new int[]{y, w - 1});
            aVisited[y][w - 1] = true;
        }

        for (int x = 0; x < w; x++) {
            if (!pVisited[0][x]) {
                pQueue.addLast(new int[]{0, x});
                pVisited[0][x] = true;
            }
            if (!aVisited[h - 1][x]) {
                aQueue.addLast(new int[]{h - 1, x});
                aVisited[h - 1][x] = true;
            }
        }

        bfs(heights, pQueue, pVisited, dy, dx, h, w);
        bfs(heights, aQueue, aVisited, dy, dx, h, w);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Deque<int[]> queue, boolean[][] visited, 
                     int[] dy, int[] dx, int h, int w) {
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            int y = curr[0];
            int x = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (visited[ny][nx] || heights[ny][nx] < heights[y][x]) continue;

                visited[ny][nx] = true;
                queue.addLast(new int[]{ny, nx});
            }
        }
    }
}