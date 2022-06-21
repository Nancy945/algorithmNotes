package sort;

import java.util.Arrays;

public class Bubble {
    /*
       对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a) {
        // 原始数组：[4, 5, 6, 3, 2, 1]
        // 6个元素，冒泡 5 次
        // 第 1 次冒泡，比较 5 次
        // 第 2 次冒泡，比较 4 次
        // ...
        // 第 1 次冒泡，结果为：[4, 5, 3, 2, 1, 6]
        // 第 2 次冒泡，结果为：[4, 3, 2, 1, 5, 6]
        // 第 3 次冒泡，结果为：[3, 2, 1, 4, 5, 6]
        // 第 4 次冒泡，结果为：[2, 1, 3, 4, 5, 6]
        // 第 5 次冒泡，结果为：[1, 2, 3, 4, 5, 6]
        System.out.printf("原始数组：%s \n", Arrays.toString(a));
        // 外层循环控制冒泡次数，内层循环控制比较次数
        // i的计算:n-1次即可完成排序
        // j的计算：第一次的比较的最大下标是n-2
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                //比较索引j和索引j+1处的值
                if (greater(a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                }
            }
            System.out.printf("第 %d 次冒泡，结果为：%s \n", i, Arrays.toString(a));
        }
        /*for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                //比较索引j和索引j+1处的值
                if (greater(a[j],a[j+1])){
                    exchange(a,j,j+1);
                }
            }
        }*/
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
