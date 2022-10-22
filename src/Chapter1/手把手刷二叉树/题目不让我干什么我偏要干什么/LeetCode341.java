package Chapter1.手把手刷二叉树.题目不让我干什么我偏要干什么;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class LeetCode341 {

//    private Iterator<Integer> it;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        //存放Nested打平的结果
//        List<Integer> result = new LinkedList<>();
//        for (NestedInteger node : nestedList) {
//            // 以每个节点为根遍历
//            traveres(node,result);
//        }
//        this.it = result.iterator();
//    }
//
//    @Override
//    public Integer next() {
//        return it.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return it.hasNext();
//    }
//
//    private void traveres(NestedInteger root, List<Integer> result) {
//        if (root.isInteger()) {
//            //达到叶子节点
//            result.add(root.getInteger());
//            return;
//        }
//        //遍历框架
//        for (NestedInteger child : root.getList()) {
//            traveres(child,result);
//        }
//
//    }

    //由于迭代器到一定数量级的时候效率慢,那么我们可以只关注叶子节构造函数多,效率低
    /*
    DFS和BFS都是不可以进行优化的那么我们有一个思路就是:每次调用next()的时候都会调用hasNext()
    每次调用next方法的时候第一个元素是整数型，直接返回并删除第一个元素即可。
   */


    //优化代码如下
//    public class NestedIterator implements Iterator<Integer> {
//        private LinkedList<NestedInteger> list;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            // 不直接用 nestedList 的引用，是因为不能确定它的底层实现
//            // 必须保证是 LinkedList，否则下面的 addFirst 会很低效
//            list = new LinkedList<>(nestedList);
//        }
//
//        public Integer next() {
//            // hasNext 方法保证了第一个元素一定是整数类型
//            return list.remove(0).getInteger();
//        }
//
//        public boolean hasNext() {
//            // 循环拆分列表元素，直到列表第一个元素是整数类型
//            while (!list.isEmpty() && !list.get(0).isInteger()) {
//                // 当列表开头第一个元素是列表类型时，进入循环
//                List<NestedInteger> first = list.remove(0).getList();
//                // 将第一个列表打平并按顺序添加到开头
//                for (int i = first.size() - 1; i >= 0; i--) {
//                    list.addFirst(first.get(i));
//                }
//            }
//            return !list.isEmpty();
//        }
//    }
}
