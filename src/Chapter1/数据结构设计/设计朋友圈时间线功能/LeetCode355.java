package Chapter1.数据结构设计.设计朋友圈时间线功能;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.*;

public class LeetCode355 {
    class Twitter {

        private static int timestamp = 0;

        //存储发送出去的推特
        private static class Tweet {
            private int id;
            private int time;
            private Tweet next;

            // 需要传入推文内容（id）和发文时间
            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        //存储好友users
        private static class User {
            private int id;
            public Set<Integer> followed;
            // 用户发表的推文链表头结点
            public Tweet head;

            public User(int userId) {
                this.id = userId;
                this.head = null;
                //关注列表
                followed = new HashSet<>();
                //关注自己
                follow(userId);
            }


            public void follow(int userId) {
                followed.add(userId);
            }

            public void unfollow(int userId) {
                // 不可以取关自己
                if (userId != this.id) {
                    followed.remove(userId);
                }
            }

            public void post(int tweetId) {
                Tweet twt = new Tweet(tweetId, timestamp);
                timestamp++;
                // 将新建的推文插入链表头
                // 越靠前的推文 time 值越大
                twt.next = head;
                head = twt;
            }

        }

        public Twitter() {

        }

        //设计一个map 让用户id与用户相对应
        private HashMap<Integer, User> userMap = new HashMap<Integer, User>();

        //User发布一条twitter
        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            User u = userMap.get(userId);
            u.post(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)) {
                return res;
            }
            //关注用户的列表
            Set<Integer> users = userMap.get(userId).followed;
            // 自动通过 time 属性从大到小排序，容量为 users 的大小
            PriorityQueue<Tweet> pq =
                    new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

            // 先将所有链表头节点插入优先级队列
            for (int id : users) {
                Tweet twt = userMap.get(id).head;
                if (twt == null) {
                    continue;
                }
                pq.add(twt);
            }

            while (!pq.isEmpty()) {
                // 最多返回 10 条就够了
                if (res.size() == 10) break;
                // 弹出 time 值最大的（最近发表的）
                Tweet twt = pq.poll();
                res.add(twt.id);
                // 将下一篇 Tweet 插入进行排序
                if (twt.next != null)
                    pq.add(twt.next);
            }
            return res;


        }

        public void follow(int followerId, int followeeId) {
            //如果follower id 不存在

            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }


            //如果被关注者的id不存在
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }

            userMap.get(followerId).follow(followeeId);
        }

        //取消关注
        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                User flwer = userMap.get(followerId);
                flwer.unfollow(followeeId);
            }
        }
    }
}
