import java.math.BigInteger;
import java.util.*;

class Solution {
    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;

        // Step 1: Build the number string
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }

        // Step 2: Convert to BigInteger and double it
        BigInteger num = new BigInteger(sb.toString());
        num = num.multiply(BigInteger.valueOf(2));

        // Step 3: Convert back to list
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
