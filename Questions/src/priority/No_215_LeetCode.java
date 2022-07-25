package priority;

import java.util.Comparator;
import java.util.PriorityQueue;

// topK问题
public class No_215_LeetCode {
    // 面试官不太需要的标准答案
    public void topKStand() {
        // 从大到小
        /* PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });*/

        // 从小到大
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(1);
        queue.add(2);


        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // 快排切分思路TopK
    static class TopKPart {

        private int sort(int[] array, int k) {
            // 第k小的数，放在k-1的位置
            // 第k大的数，放在array.length-1 - (k-1) = array.length-k
            return qSort(array, 0, array.length - 1, array.length - k);
        }

        private int qSort(int[] array, int lo, int hi, int K) {
            int index = partition(array, lo, hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引

            if (index == K) {
                return array[index];
            } else if (K > index) {
                return qSort(array, index + 1, hi, K);
            } else {
                return qSort(array, lo, index - 1, K);
            }

        }


        public int partition(int[] a, int lo, int hi) {
            //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
            int left = lo, right = hi + 1;
            //确定分界值
            int key = a[lo];
            //切分
            while (true) {
                //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
                while (less(a[++left], key)) {
                    if (left == hi) break;
                }
                //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
                while (less(key, a[--right])) {
                    if (right == lo) break;
                }

                //判断 left>=right,如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可
                if (left >= right) break;

                exchange(a, left, right);
            }

            //交换分界值
            exchange(a, lo, right);
            return right;
        }

        private boolean less(int num, int key) {
            return num < key;
        }

        private void exchange(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }


    }

    static class TopKHeap{
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
            // Java 里没有 heapify ，因此我们逐个将前 k 个元素添加到 minHeap 里
            for (int i = 0; i < k; i++) {
                minHeap.offer(nums[i]);
            }

            for (int i = k; i < len; i++) {
                // 看一眼，不拿出，因为有可能没有必要替换
                Integer topElement = minHeap.peek();
                // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                if (nums[i] > topElement) {
                    // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
            return minHeap.peek();
        }


    }

    public static void main(String[] args) {
        int k = 1;
        int[] array = {5, 1, 3, 2, 4};
//        int result = new TopKPart().sort(array, k);
        int result = new TopKHeap().findKthLargest(array, k);
        System.out.println("result:" + result);
    }
}
