package linear;

import java.util.HashSet;

public class CircleEntry {
    private static class ListNode<T> {
        //存储数据
        T item;
        //下一个结点
        ListNode<T> next;

        public ListNode(T item, ListNode<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * //时间O(n)空间O(1)
     * <p>
     * //构思巧妙，但复现不难。
     * //过程是这样的：双指针，fast每次走两步，slow每次走一步；
     * //第一阶段，fast在前，slow在后，如果fast追上slow，说明有环。若fast走到null说明无环。
     * //第二阶段，back从头开始; front从fast==slow位置开始。现在front和back同速，恰巧可以在入口节点相遇。分析如上图【难点】
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (true) {
            if (fast == null || fast.next == null) return null;//退出条件1：无环，fast走到null
            fast = fast.next.next;//fast二倍速
            slow = slow.next;//fast的判空已经覆盖了slow; slow不需要单独判空
            if (fast == slow) break;//退出条件2：有环相遇时
        }
        ListNode front = fast;//front从fast==slow位置、一倍速
        ListNode back = pHead;//back从头开始、一倍速
        while (back != front) {
            back = back.next;
            front = front.next;
        }
        return front;//front==back
    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        //建立哈希表：存储、查找node //哈希表的特点：便于按值查找；但浪费空间，且易碰撞、无法排序
        while (pHead != null) {
            if (set.contains(pHead)) return pHead;//有重复，就说明是环入口 //可以证明，单链最多一个环
            else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;//无环单链

    }//时间O(n) 空间O(n)
//如果用ArrayList的STL那么时间复杂度变为O(n^2)
}
