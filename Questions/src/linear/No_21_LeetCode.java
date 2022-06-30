package linear;

public class No_21_LeetCode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode dummyHead = new ListNode(0, null);

        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

     /*   while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }*/

        // 任一为空，直接连接另一条链表
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return dummyHead.next;
    }

}