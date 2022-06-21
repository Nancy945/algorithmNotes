
public class Insertion {
    /*
       对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a) {
        // 8个元素，排序 7 次
        // 第 1 次排序，有序列表中有 1 个元素参与比较
        // 第 2 次排序，有序列表中有 2 个元素参与比较
        // ...
        // 第 1 次排序，最多需要比较 1 次
        // 第 2 次排序，最多需要比较 2 次
        // 第 3 次排序，最多需要比较 3 次
        // ...
        // 外层循环控制排序次数，内层循环控制比较次数
        for (int i = 1; i < a.length; i++) {
            System.out.println(i);
            for (int j = i; j > 0; j--) { // 倒序比较，所以 j--
                //比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大，则交换数据，如果不大，那么就找到合适的位置了，退出循环即可；
                // NOTE: 这里一定注意 不是a[i]和a[j]， 是a[j]和a[j-1]。  比如2,3,1 这样的情况，如果是前者会变成1,3,2,是错误的。
                if (greater(a[j - 1], a[j])) {
                    exchange(a, j - 1, j);
                } else {
                    break;
                }
            }

        }
    }

    /*
        比较v元素是否大于w元素
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /*
    数组元素i和j交换位置
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
