package linear;

public class No_25_LeetCode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;

        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }

        int times = count / k;

        ListNode prev = null;
        ListNode left = head;
        ListNode right;

        ListNode newHead = head;

        for (int i = 0; i < times; i++) {
            right = left;
            for (int j = 0; j < k - 1; j++) {
                right = right.next;
            }
            tmp = right.next;

            reverse(left, right);

            if (prev != null) {
                prev.next = right;
            } else {
                newHead = right;
            }

            prev = left;
            left = tmp;
        }

        return newHead;

    }

    private void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head + ",");
            head = head.next;
        }
        System.out.println();
    }

    private void reverse(ListNode left, ListNode right) {
        ListNode n1 = null;
        ListNode n2 = left;
        final ListNode n3 = right.next;
        while (n2 != n3) {
            ListNode tmp = n2.next;
            n2.next = n1;

            n1 = n2;
            n2 = tmp;

        }

        left.next = n3;

    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode node;
        ListNode lastNode = null;
        for (int i = 1; i <= 5; i++) {
            node = new ListNode(i);
            if (lastNode != null) {
                lastNode.next = node;
            }
            lastNode = node;
            if (i == 1) {
                head = node;
            }
        }


        No_25_LeetCode obj = new No_25_LeetCode();
        ListNode resultHead = obj.reverseKGroup1(head, 3);
        obj.printNode(resultHead);

    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode beforeHead = new ListNode(0);
        ListNode prev = beforeHead;
        ListNode curr = head;
        ListNode next;

        beforeHead.next = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }

        return beforeHead.next;
    }
}
