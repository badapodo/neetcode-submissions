class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] graph = new int[1002];
        for (int h : hand) {
            graph[h]++;
        }

        int[] start = new int[1002];
        int active = 0;

        for (int i = 0; i <= 1000; i++) {

            // groupSize 전에 시작한 그룹 종료
            if (i >= groupSize) {
                active -= start[i - groupSize];
            }

            // 기존 그룹을 이어갈 카드가 부족
            if (graph[i] < active) {
                return false;
            }

            // 남는 카드는 새로운 그룹 시작
            int newGroup = graph[i] - active;
            start[i] = newGroup;
            active += newGroup;
        }

        // 1000 이후에도 끝나지 않은 그룹이 있다면 실패
        for (int i = 1001; i < 1001 + groupSize; i++) {
            if (i >= groupSize && i - groupSize < start.length) {
                active -= start[i - groupSize];
            }

            if (active != 0) {
                return false;
            }
        }

        return true;
    }
}