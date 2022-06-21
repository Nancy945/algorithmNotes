public class Shell {
    /*
       对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a) {
        //1.根据数组a的长度，确定增长量h的初始值；
        /*int h = 1;
        while(h<a.length/2){//5
            h = 2*h+1; //3,7
        }*/
        int h = a.length / 2;
        //2.希尔排序
//        选定一个增长量h，按照增长量h作为数据分组的依据
//        对数据进行分组，h为n，得到n组数据，对每组数据完成插入排序；
//
//        最外层while循环控制分组的次数
//
//        外层for循环得到待插入的元素
//        内层for循环控制比较的次数
//
//        当 h=5 时，要插入元素的索引位置从 5 开始
//        当 h=2 时，要插入元素的索引位置从 2 开始
//        当 h=1 时，要插入元素的索引位置从 1 开始
//
//        所以，i = h， i < a.length
//
//        因为是倒序比较，且元素之间索引相隔h，所以 j-=h
//        j 从 h 开始，所以 j 的值要大于等于 h

        while (h >= 1) {
            System.out.printf(" -----------h: %d \n", h);
            //排序
            //2.1.找到待插入的元素
            for (int i = h; i < a.length; i++) {
                System.out.printf(" i: %d \n", i);
                //2.2把待插入的元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    System.out.printf(" j: %d ", j);
                    //待插入的元素是a[j],比较a[j]和a[j-h]
                    System.out.printf("%d&%d", j - h, j);
                    if (greater(a[j - h], a[j])) {
                        //交换元素
                        exchange(a, j - h, j);
                    } else {
                        //待插入元素已经找到了合适的位置，结束循环；
                        System.out.println("");
                        break;
                    }
                    //System.out.println("");
                }
                System.out.println("");
            }
            //减小h的值
            h = h / 2;
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
