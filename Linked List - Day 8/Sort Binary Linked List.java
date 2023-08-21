public class Solution {
    public ListNode solve(ListNode A) {
        ListNode one = A;
        ListNode zero = A.next;
        while (zero != null) {
            if (zero.val == 0) {
                one.next = zero.next;  // Skipping the zero node
                zero.next = A;         // Setting the next of zero to the original head A
                A = zero;              // Updating A to the new head (zero)
                zero = one.next;       // Moving zero to the next node after one
            } else {
                one = zero;            // Moving one to zero
                zero = zero.next;      // Moving zero to the next node
            }
        }
        return A;                     // Returning the modified linked list
    }
}
