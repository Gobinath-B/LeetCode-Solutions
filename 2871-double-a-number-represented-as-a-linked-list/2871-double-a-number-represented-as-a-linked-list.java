import java.math.BigInteger;
import java.util.*;

class Solution {
    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;

        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }

        BigInteger num = new BigInteger(sb.toString());
        num = num.multiply(BigInteger.valueOf(2));

        String doubledStr = num.toString();
        ListNode dummy = new ListNode(0);
        temp = dummy;
        for (char c : doubledStr.toCharArray()) {
            temp.next = new ListNode(c - '0');
            temp = temp.next;
        }

        return dummy.next;
    }
}
