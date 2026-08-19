class Tweet {
    int id;
    int tweetId;

    public Tweet(int id, int tweetId) {
        this.id = id;
        this.tweetId = tweetId;
    }
}

class Twitter {
    Map<Integer, Set<Integer>> follwer;
    Map<Integer, List<Tweet>> tweet;
    int rowId = 0;

    public Twitter() {
        follwer = new HashMap<>();
        tweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.putIfAbsent(userId, new ArrayList<>());

        tweet.get(userId).add(
            new Tweet(rowId++, tweetId)
        );
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>();

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.id, a.id));

        // 내 트윗
        if (tweet.containsKey(userId)) {
            List<Tweet> ts = tweet.get(userId);

            for (int i = 0; i < Math.min(10, ts.size()); i++) {
                pq.add(ts.get(ts.size() - 1 - i));
            }
        }

        // 내가 팔로우한 사람들의 트윗
        if (follwer.containsKey(userId)) {
            for (int u : follwer.get(userId)) {

                if (!tweet.containsKey(u)) {
                    continue;
                }

                List<Tweet> ts = tweet.get(u);

                for (int i = 0; i < Math.min(10, ts.size()); i++) {
                    pq.add(ts.get(ts.size() - 1 - i));
                }
            }
        }

        // 가장 최신 트윗 10개
        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty()) {
                break;
            }

            ret.add(pq.remove().tweetId);
        }

        return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        follwer.putIfAbsent(followerId, new HashSet<>());
        follwer.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!follwer.containsKey(followerId)) {
            return;
        }

        follwer.get(followerId).remove(followeeId);
    }
}