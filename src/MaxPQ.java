// 用二叉堆实现优先级队列
public class MaxPQ
    <Key extends Comparable<Key>> {
    // 存储元素的数组
    private Key[] pq;
    // 优先队列中的元素个数
    private int N = 0;

    public MaxPQ(int cap) {
        // 因为数组的第0位不用，所以扩展一位
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key Max() {
        return pq[1];
    }

    private void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    private Key delMax() {
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    private void sink(int k) {
        while (left(k) <= N) {
            int older = left(k);
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            if (less(older, k)) break;
            exch(older, k);
            k = older;
        }
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int left(int k) {
        return k * 2;
    }

    private int right(int k) {
        return k * 2 + 1;
    }

    private int parent(int k) {
        return k / 2;
    }
}
