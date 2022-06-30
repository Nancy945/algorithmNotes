package linear;

import java.util.HashSet;
import java.util.Set;

public class No_160_LeetCode {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aNodes = new HashSet<>();

        ListNode tmp = headA;
        while (tmp != null) {
            aNodes.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null) {
            if (aNodes.contains(tmp)) return tmp;
            tmp = tmp.next;
        }

        return null;
    }

}
