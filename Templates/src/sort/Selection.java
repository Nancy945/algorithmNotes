
public class Selection {
    /*
       对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a) {
        /*for(int i=0;i<=a.length-2;i++){
            //定义一个变量，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            for(int j=i+1;j<a.length;j++){
                //需要比较最小索引minIndex处的值和j索引处的值；
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }

            //交换最小元素所在索引minIndex处的值和索引i处的值
            exchange(a,i,minIndex);
        }*/
        // 8个元素，排序 7 次
        // 第 0 次排序，比较 7 次
        // 第 1 次排序，比较 6 次
        // ...
        // 外层循环控制排序次数，内层循环控制比较次数
        for (int i = 0; i < a.length - 1; i++) {
            //定义一个变量，记录最小元素所在的索引，默认为第一个元素所在的位置
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                //如果比 minIndex 处的值小，对 minIndex 重新赋值
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }

            //交换最小元素所在索引minIndex处的值和索引i处的值
            exchange(a, i, minIndex);
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
