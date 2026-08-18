class KthLargest {
    private List<Integer> lst;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        lst = new ArrayList<>();
        for (int n : nums) lst.add(n);
        lst.sort(Comparator.naturalOrder());
    }
    
    public int add(int val) {
        lst.add(val);
        lst.sort(Comparator.naturalOrder());
        return lst.get(lst.size() - k);
    }
}
