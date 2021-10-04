import java.util.*;

// 355.设计推特
public class Twitter {
    private static int timestamp = 0;
    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            this.head = null;
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    // 将用户id与用户映射起来
    private HashMap<Integer, User> userMap = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    // 有序链表通过优先级队列实现合并
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        // 获取关注列表的id
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq =
                new PriorityQueue<>(users.size(), (a, b)->(b.time - a.time));
        for (int id: users) {
            Tweet twt = userMap.get(id).head;
            // 该用户没有发过推特
            if (twt == null) continue;
            pq.add(twt);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10) break;
            Tweet twt = pq.poll();
            res.add(twt.id);
            if (twt.next != null) {
                pq.add(twt.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
