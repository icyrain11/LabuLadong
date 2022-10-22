package Chapter1.数据结构设计.手撸LRU算法;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.HashMap;

@SuppressWarnings("All")
public class LeetCode146 {
    class Node {
        int key, val;
        public Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        //头尾虚节点
        private Node head, tail;
        //获取元素个数
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            tail.prev.next = tail;
            tail.prev = head;
            size = 0;
        }

        //在尾链表添加新的节点O(1)
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        //删除末尾节点
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        //删除末尾节点
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        //返回链表长度
        public int size() {
            return this.size;
        }

    }

    class LRUCache {

        //key -> Node(key,val)
        private HashMap<Integer, Node> map;
        //Node(k1,v1)<-> Node(k2,v2)......
        private DoubleList cache;
        //最大容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 将该数据提升为最近使用的
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 删除旧的数据
                deleteKey(key);
                // 新插入的数据为最近使用的数据
                addRecently(key, value);
                return;
            }

            if (cap == cache.size()) {
                // 删除最久未使用的元素
                removeLeastRecently();
            }
            // 添加为最近使用的元素
            addRecently(key, value);
        }

        //将某个key提升为最近使用
        private void makeRecently(int key) {
            Node x = map.get(key);
            //先从链表中删除节点
            cache.remove(x);
            //重新插到队尾
            cache.addLast(x);
        }

        //添加最近使用的元素
        public void addRecently(int key, int val) {
            Node x = new Node(key, val);
            //链表尾部就是最近使用的网络
            cache.addLast(x);
            //在map中添加key的映射
            map.put(key, x);
        }

        //删除某个key
        private void deleteKey(int key) {
            Node x = map.get(key);
            //从链表中删除
            cache.remove(x);
            //从map中删除
            map.remove(key);
        }

        // 删除最久未使用的元素
        private void removeLeastRecently() {
            // 链表头部的第一个元素就是最久未使用的
            Node deletedNode = cache.removeFirst();
            // 同时别忘了从 map 中删除它的 key
            int deletedKey = deletedNode.key;
            map.remove(deletedKey);
        }

    }

    //答案
//
//    class LRUCache {
//        int cap;
//        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//        public LRUCache(int capacity) {
//            this.cap = capacity;
//        }
//
//        public int get(int key) {
//            if (!cache.containsKey(key)) {
//                return -1;
//            }
//            // 将 key 变为最近使用
//            makeRecently(key);
//            return cache.get(key);
//        }
//
//        public void put(int key, int val) {
//            if (cache.containsKey(key)) {
//                // 修改 key 的值
//                cache.put(key, val);
//                // 将 key 变为最近使用
//                makeRecently(key);
//                return;
//            }
//
//            if (cache.size() >= this.cap) {
//                // 链表头部就是最久未使用的 key
//                int oldestKey = cache.keySet().iterator().next();
//                cache.remove(oldestKey);
//            }
//            // 将新的 key 添加链表尾部
//            cache.put(key, val);
//        }
//
//        private void makeRecently(int key) {
//            int val = cache.get(key);
//            // 删除 key，重新插入到队尾
//            cache.remove(key);
//            cache.put(key, val);
//        }
//    }


}
