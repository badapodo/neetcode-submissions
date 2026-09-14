class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        Set<Integer>[] set = new Set[3];

        for (int i = 0; i < 3; i++) {
            set[i] = new HashSet<>();
        }
        boolean condition = false;
        for (int i = 0; i < n; i++) {
            boolean currCondition = true;

            for (int j = 0; j < 3; j++) {
                int curr = triplets[i][j];
                if (target[j] < curr) {
                    currCondition = false;
                }
            }
            
            if (currCondition) {
                condition = true;
                for (int j = 0; j < 3; j++) {
                    set[j].add(triplets[i][j]);
                }
            }
        }

        if (!condition) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (!set[i].contains(target[i])) {
                return false;
            }
        }

        return true;
    }
}
