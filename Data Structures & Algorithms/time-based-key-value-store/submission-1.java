class Data {
    String mood;
    int time;
    public Data(String mood, int time) {
        this.mood = mood;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        String ret = ""; 
        List<Data> lst = map.get(key);
        int l = 0;
        int r = lst.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            int currentTime = lst.get(mid).time; 
            
            if (currentTime == timestamp) {
                return lst.get(mid).mood;
            } else if (currentTime > timestamp) {
                r = mid - 1;
            } else {
                ret = lst.get(mid).mood; 
                l = mid + 1;
            }
        }
        
        return ret;
    }
}