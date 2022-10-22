package Chapter1.数据结构设计.二叉堆实现优先队列;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class BinaryImpQueue {

    public class MaxPq<Key extends Comparable<Key>> {
        //存储元素的数组
        private Key[] pq;
        //当前Priority Queue中元素的个数
        private int N = 0;

        public MaxPq(int cap) {
            //索引0不用多分配一个空间
            pq = (Key[]) new Comparable[cap + 1];

        }

        //返回pq中最大的元素
        public Key Max() {
            return pq[0];
        }


        /* 插入元素 e */
        public void insert(Key e) {
            N++;
            // 先把新元素加到最后
            pq[N] = e;
            // 然后让它上浮到正确的位置
            swim(N);
        }

        /* 删除并返回当前队列中最大元素 */
        public Key delMax() {
            //最大堆的堆顶就是最大元素
            Key max = pq[1];
            // 把这个最大元素换到最后，删除之
            swap(1, N);
            pq[N] = null;
            N--;
            // 让 pq[1] 下沉到正确位置
            sink(1);
            return max;
        }

        /* 上浮第 k 个元素，以维护最大堆性质 */
        private void swim(int k) {
            while (k > 1 && less(parent(k), k)) {
                // 如果第 k 个元素比上层大
                // 将 k 换上去
                swap(k, parent(k));
                k = parent(k);
            }
        }

        /* 下沉第 k 个元素，以维护最大堆性质 */
        private void sink(int k) {
            //如果沉到底了那么就无法继续了
            while (left(k) <= N) {
                //先假设左边比较大
                int older = left(k);
                //如果右边的比较小
                if (older > right(k)) {
                    older = right(k);
                }
                //如果节点比两个孩子大
                if (less(older, k)) {
                    break;
                }
                //否则不符合最大堆那么进行交换
                swap(k, older);
                k = older;
            }
        }

        //数组中两个值交换
        public void swap(int i, int j) {
            Key temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }

        //判断pq[i]是否比pq[j]小
        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

    }

    int parent(int root) {
        return root / 2;
    }

    int left(int root) {
        return root * 2;
    }

    int right(int root) {
        return root * 2 + 1;
    }
}
