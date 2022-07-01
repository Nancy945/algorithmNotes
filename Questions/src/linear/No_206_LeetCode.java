package linear;

import java.util.Arrays;

public class No_206_LeetCode {

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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        String s = ",,1,,";
        String[] strings = s.split(",", -1);
        System.out.println(Arrays.toString(strings));
        System.out.println(strings.length);
    }
}

