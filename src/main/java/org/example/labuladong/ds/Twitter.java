package org.example.labuladong.ds;

import java.util.*;

class Twitter {
    private int timestamp; // 用来排序
    private class Tweet {
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private class User {
        private int id;
        Set<Integer> followed; // 存放关注列表
        Tweet head;
        public User(int userId) {
            this.id = userId;
            followed = new HashSet<>();
            this.head = null;
            follow(id); // 关注下自己
        }
        public void follow(int followeeId) {
            followed.add(followeeId);
        }
        public void unfollow(int followeeId) {
            if (!(this.id == followeeId)) {
                followed.remove(followeeId); // 不允许取关自己
            }
        }
        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    // 将用户和User对象关联起来
    HashMap<Integer, User> userMap = new HashMap<>();
    public Twitter(){}
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId))
            userMap.get(followerId).unfollow(followeeId);
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res; // 用户不存在、直接返回

        Set<Integer> users = userMap.get(userId).followed; // 获取所有的关注用户
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b)->(b.time - a.time));

        // 将关注用户的推文头指针放入优先级队列
        for (int id : users) {
            Tweet tweet = userMap.get(id).head;
            if (tweet == null) continue;
            pq.add(tweet);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10) break;
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (!(tweet.next == null))
                pq.add(tweet.next);
        }
        return res;
    }
}
