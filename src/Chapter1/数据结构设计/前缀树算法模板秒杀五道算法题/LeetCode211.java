package Chapter1.数据结构设计.前缀树算法模板秒杀五道算法题;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode211 {
    class TrieSet {
        // 底层用一个 TrieMap，键就是 TrieSet，值仅仅起到占位的作用
        // 值的类型可以随便设置，我参考 Java 标准库设置成 Object
        private final TrieMap<Object> map = new TrieMap<>();

        /***** 增 *****/

        // 在集合中添加元素 key
        public void add(String key) {
            map.put(key, new Object());
        }

        /***** 删 *****/

        // 从集合中删除元素 key
        public void remove(String key) {
            map.remove(key);
        }

        /***** 查 *****/

        // 判断元素 key 是否存在集合中
        public boolean contains(String key) {
            return map.containsKey(key);
        }

        // 在集合中寻找 query 的最短前缀
        public String shortestPrefixOf(String query) {
            return map.shortestPrefixOf(query);
        }

        // 在集合中寻找 query 的最长前缀
        public String longestPrefixOf(String query) {
            return map.longestPrefixOf(query);
        }

        // 在集合中搜索前缀为 prefix 的所有元素
        public List<String> keysWithPrefix(String prefix) {
            return map.keysWithPrefix(prefix);
        }

        // 判断集合中是否存在前缀为 prefix 的元素
        public boolean hasKeyWithPrefix(String prefix) {
            return map.hasKeyWithPrefix(prefix);
        }

        // 通配符 . 匹配任意字符，返回集合中匹配 pattern 的所有元素
        public List<String> keysWithPattern(String pattern) {
            return map.keysWithPattern(pattern);
        }

        // 通配符 . 匹配任意字符，判断集合中是否存在匹配 pattern 的元素
        public boolean hasKeyWithPattern(String pattern) {
            return map.hasKeyWithPattern(pattern);
        }

        // 返回集合中元素的个数
        public int size() {
            return map.size();
        }
    }

    class TrieMap<V> {
        // ASCII 码个数
        private static final int R = 256;
        // 当前存在 Map 中的键值对个数
        private int size = 0;

        public static class TrieNode<V> {
            V val = null;
            TrieNode<V>[] children = new TrieNode[R];
        }

        //Trie树的根节点
        TrieNode<V> root = null;

        public int size() {
            return size;
        }

        public TrieNode<V> getNode(TrieNode<V> node, String key) {
            TrieNode<V> p = node;
            //从
            for (int i = 0; i < key.length(); i++) {
                if (p == null) {
                    //无法向下搜索
                    return null;
                }
                char c = key.charAt(i);
                p = p.children[c];
            }
            return p;
        }

        //获取搜索树对应的值
        public V get(String key) {
            //从root开始搜索
            TrieNode<V> x = getNode(root, key);
            if (x == null || x.val == null) {
                return null;
            }

            return x.val;
        }

        //判断key是否存在map中
        public boolean containsKey(String key) {
            return get(key) != null;
        }

        // 判断是和否存在前缀为 prefix 的键
        public boolean hasKeyWithPrefix(String prefix) {
            //只要找到一个存在的即可
            return getNode(root, prefix) != null;
        }


        // 在所有键中寻找 query 的最短前缀
        public String shortestPrefixOf(String query) {
            TrieNode<V> p = root;
            for (int i = 0; i < query.length(); i++) {
                //无法搜索到该key
                if (p == null) {
                    return "";
                }
                if (p.val != null) {
                    return query.substring(0, i);
                }
                //向下搜索
                char c = query.charAt(i);
                p = p.children[c];
            }
            if (p != null && p.val != null) {
                // 如果 query 本身就是一个键
                return query;
            }
            return "";
        }

        //寻找最长前缀
        public String longestPrefixOf(String query) {
            TrieNode<V> p = root;
            // 记录前缀的最大长度
            int max_len = 0;
            for (int i = 0; i < query.length(); i++) {
                //无法搜索到该key
                if (p == null) {
                    return "";
                }
                if (p.val != null) {
                    max_len = i;
                }
                //向下搜素
                char c = query.charAt(i);
                p = p.children[c];
            }

            if (p != null && p.val != null) {
                // 如果 query 本身就是一个键
                return query;
            }

            return query.substring(0, max_len);
        }

        // 搜索前缀为 prefix 的所有键
        public List<String> keysWithPrefix(String prefix) {
            List<String> res = new LinkedList<>();
            // 找到匹配 prefix 在 Trie 树中的那个节点
            TrieNode<V> x = getNode(root, prefix);
            // DFS 遍历以 x 为根的这棵 Trie 树
            traverse(x, new StringBuilder(prefix), res);
            return res;
        }

        public void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
            if (node == null) {
                return;
            }
            if (node.val != null) {
                // 找到一个 key，添加到结果列表中
                res.add(path.toString());
            }
            //回溯遍历
            for (int c = 0; c < R; c++) {
                //做选择
                path.append(c);
                traverse(node.children[c], path, res);
                //撤销选择
                path.deleteCharAt(path.length() - 1);
            }
        }


        //通配符,匹配任意字符
        public List<String> keysWithPattern(String pattern) {
            List<String> res = new LinkedList<>();
            traverse(root, new StringBuilder(), pattern, 0, res);
            return res;
        }

        //遍历函数
        public void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
            if (node == null) {
                //如果不存在
                return;
            }
            //找到该通配符
            if (i == pattern.length()) {
                //匹配完成
                if (node.val != null) {
                    //如果节点里面有val
                    res.add(path.toString());
                }
                return;
            }
            char c = pattern.charAt(i);
            if (c == '.') {
                // pattern[i] 是通配符，可以变化成任意字符
                // 多叉树（回溯算法）遍历框架
                for (char j = 0; j < R; j++) {
                    path.append(j);
                    traverse(node.children[j], path, pattern, i + 1, res);
                    path.deleteCharAt(path.length() - 1);
                }
            } else {
                // pattern[i] 是普通字符 c
                path.append(c);
                traverse(node.children[c], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        }

        // 判断是和否存在前缀为 prefix 的键
        public boolean hasKeyWithPattern(String pattern) {
            // 从 root 节点开始匹配 pattern[0..]
            return hasKeyWithPattern(root, pattern, 0);
        }

        // 函数定义：从 node 节点开始匹配 pattern[i..]，返回是否成功匹配
        private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
            if (node == null) {
                // 树枝不存在，即匹配失败
                return false;
            }
            if (i == pattern.length()) {
                // 模式串走到头了，看看匹配到的是否是一个键
                return node.val != null;
            }
            char c = pattern.charAt(i);
            // 没有遇到通配符
            if (c != '.') {
                // 从 node.children[c] 节点开始匹配 pattern[i+1..]
                return hasKeyWithPattern(node.children[c], pattern, i + 1);
            }
            // 遇到通配符
            for (int j = 0; j < R; j++) {
                // pattern[i] 可以变化成任意字符，尝试所有可能，只要遇到一个匹配成功就返回
                if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                    return true;
                }
            }
            // 都没有匹配
            return false;
        }

        // 在 map 中添加或修改键值对
        public void put(String key, V val) {
            if (!containsKey(key)) {
                // 新增键值对
                size++;
            }
            // 需要一个额外的辅助函数，并接收其返回值
            root = put(root, key, val, 0);
        }

        // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
        private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
            if (node == null) {
                // 如果树枝不存在，新建
                node = new TrieNode<>();
            }
            if (i == key.length()) {
                // key 的路径已插入完成，将值 val 存入节点
                node.val = val;
                return node;
            }
            char c = key.charAt(i);
            // 递归插入子节点，并接收返回值
            node.children[c] = put(node.children[c], key, val, i + 1);
            return node;
        }

        // 在 Map 中删除 key
        public void remove(String key) {
            if (!containsKey(key)) {
                return;
            }
            // 递归修改数据结构要接收函数的返回值
            root = remove(root, key, 0);
            size--;
        }


        // 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
        private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
            if (node == null) {
                return null;
            }
            if (i == key.length()) {
                // 找到了 key 对应的 TrieNode，删除 val
                node.val = null;
            } else {
                char c = key.charAt(i);
                // 递归去子树进行删除
                node.children[c] = remove(node.children[c], key, i + 1);
            }
            // 后序位置，递归路径上的节点可能需要被清理
            if (node.val != null) {
                // 如果该 TireNode 存储着 val，不需要被清理
                return node;
            }
            // 检查该 TrieNode 是否还有后缀
            for (int c = 0; c < R; c++) {
                if (node.children[c] != null) {
                    // 只要存在一个子节点（后缀树枝），就不需要被清理
                    return node;
                }
            }
            // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
            return null;
        }

    }
}
