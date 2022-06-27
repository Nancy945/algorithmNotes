package priority;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
    //存储堆中的元素.基于堆的完全二叉树
    private final Key[] items;
    //记录堆中元素的个数。存储于pq[1..N]中，pq[0]为了简化计算没有使用
    private int N;


    public MaxPriorityQueue(int capacity) {
        this.items = (Key[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        Key tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(Key key) {
        items[++N] = key;
        swim(N);
    }

    //删除堆中最大的元素,并返回这个最大元素
    public Key delMax() {
        Key max = items[1];
        exch(1, N--);
        items[N + 1] = null;
        sink(1);
        return max;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        while (k <= 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {

        while (k * 2 <= N) {
            // maxIndex初始为较小的子节点
            int maxIndex = k * 2;
            // 如果存在右侧节点，且比左侧大，
            if (maxIndex < N && less(maxIndex, maxIndex + 1)) {
                maxIndex++;
            }

            // k比较大的子节点都大了，说明下沉完成
            if (!less(k, maxIndex)) {
                break;
            }
            // 否则下沉
            exch(k, maxIndex);
            k = maxIndex;
        }

    }

}
