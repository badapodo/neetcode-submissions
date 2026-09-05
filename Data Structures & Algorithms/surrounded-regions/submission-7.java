class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int h = board.length;
        int r = board[0].length;
        int dummyNode = h * r;

        UnionFind uf = new UnionFind(dummyNode + 1);

        int[] dy = {0, 1};
        int[] dx = {1, 0};

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (board[y][x] == 'O') {
                    int currNode = y * r + x;

                    if (y == 0 || y == h - 1 || x == 0 || x== r - 1) {
                        uf.union(currNode, dummyNode);
                    }

                    for (int i = 0; i < 2; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];

                        if (ny < h && nx < r && board[ny][nx] == 'O') {
                            uf.union(currNode, ny * r + nx);
                        }
                    }
                }
            }
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (board[y][x] == 'O') {
                    int currNode = y * r + x;
                    if (!uf.isConnected(currNode, dummyNode)) {
                        board[y][x] = 'X';
                    }
                }
            }
        }
    }
}
