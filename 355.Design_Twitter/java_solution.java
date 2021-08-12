// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-2/she-ji-twitter
class Twitter {
    Map<Integer, User> users;
    int time;
    class User {
        Set<User> follows;
        Tweet tweetHead;
        public User() {
            follows = new HashSet<>(Arrays.asList(this));
            tweetHead = new Tweet(-1, -1);
        }
    }
    class Tweet {
        int time;
        int tweetId;
        Tweet next;
        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
            next = null;
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        addUserIfAbsent(userId);
        User user = users.get(userId);
        Tweet newTweet = new Tweet(this.time++, tweetId);
        newTweet.next = user.tweetHead.next;
        user.tweetHead.next = newTweet;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        addUserIfAbsent(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));
        List<Integer> feed = new ArrayList<>();
        User user = users.get(userId);
        for (User follow: user.follows) {
            if (follow.tweetHead.next != null) {
                pq.add(follow.tweetHead.next);
            }
        }
        while (feed.size() < 10 && !pq.isEmpty()) {
            Tweet cur = pq.poll();
            feed.add(cur.tweetId);
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        addUserIfAbsent(followerId);
        addUserIfAbsent(followeeId);
        users.get(followerId).follows.add(users.get(followeeId));
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        addUserIfAbsent(followerId);
        addUserIfAbsent(followeeId);
        users.get(followerId).follows.remove(users.get(followeeId));
    }

    private void addUserIfAbsent(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User());
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
