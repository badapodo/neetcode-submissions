class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int h : hand) {
            int currCnt = map.getOrDefault(h, 0);
            if (currCnt == 0) continue;

            for (int i = 0; i < groupSize; i++) {
                int index = i + h;
                if (!map.containsKey(index)) {
                    return false;
                }
                int nextCnt = map.get(index) - 1;
                if (nextCnt == 0) {
                    map.remove(index);
                    continue;
                }
                map.put(index, nextCnt);
            }
        }

        return map.size() == 0;
    }
}
